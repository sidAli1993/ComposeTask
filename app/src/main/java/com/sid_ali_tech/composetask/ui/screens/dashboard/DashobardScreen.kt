package com.sid_ali_tech.composetask.ui.screens.dashboard

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.gson.Gson
import com.sid_ali_tech.composetask.common.Constants.TAG
import com.sid_ali_tech.composetask.common.Constants.jsonString
import com.sid_ali_tech.composetask.common.Response
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import com.sid_ali_tech.composetask.data.models.MyData
import com.sid_ali_tech.composetask.ui.components.MedicationCardRow

@Composable
fun DashboardScreen(navHostController: NavHostController,userName:String) {
    val context= LocalContext.current
    val dashboardViewModel: DashboardViewModel = hiltViewModel()


    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Welcome $userName", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Default))

            Spacer(modifier = Modifier.height(20.dp))


            GetMedications(context,dashboardViewModel)


        }
    }
}

@Composable
fun GetMedications(context: Context,dashboardViewModel: DashboardViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val gson = Gson()
        val data = gson.fromJson(jsonString, MyData::class.java)

        Log.d(TAG, "data model $data", )
//        val medicationsList: List<Medication> = data.problems.flatMap { it.medications }
        MedicationCardRow(modifier = Modifier.fillMaxWidth(), problem = data.problems)

//        saving data in local dao
        dashboardViewModel.saveRec(dtoHealthRecord = DTOHealthRecord(myData = data))

        //            collecting values in composable
        val checkSaved = dashboardViewModel.saveHRec.collectAsState(initial = false)

        checkSaved.value.let {result->
            when(result){
                is Response.Loading->{
                    Log.d(TAG, "DashboardScreen: it is loading")
                }
                is Response.Success<*> -> {
                    Toast.makeText(context, "Saved in local db", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "DashboardScreen success: ${result.data}")
                }
                is Response.Error->{
                    Log.d(TAG, "DashboardScreen: ${result.message}")
                }
            }

        }
    }

}
