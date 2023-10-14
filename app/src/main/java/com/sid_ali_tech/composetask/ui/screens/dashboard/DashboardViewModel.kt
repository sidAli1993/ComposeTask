package com.sid_ali_tech.composetask.ui.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sid_ali_tech.composetask.common.Response
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import com.sid_ali_tech.composetask.domain.HealthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val healthUseCases: HealthUseCases) :ViewModel() {

    private var _saveHRec =
        MutableStateFlow<Response<Boolean>>(Response.Success(false))

    val saveHRec: StateFlow<Response<Boolean>> = _saveHRec


    private var _getHRec =
        MutableStateFlow<Response<List<DTOHealthRecord>>>(Response.Success(emptyList()))

    val getHRec: StateFlow<Response<List<DTOHealthRecord>>> = _getHRec


    fun saveRec(dtoHealthRecord: DTOHealthRecord){
        viewModelScope.launch {
            healthUseCases.saveHealthRecordUseCase.invoke(dtoHealthRecord).collect(){
                _saveHRec.value=it
            }
        }
    }

    fun getRec(){
        viewModelScope.launch {
            healthUseCases.getHealthRecordUseCase.invoke().collect(){
                _getHRec.value=it
            }
        }
    }

}