package com.sid_ali_tech.composetask.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sid_ali_tech.composetask.data.models.Problem
import com.sid_ali_tech.composetask.ui.theme.ItemBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationCardRow(modifier: Modifier, problem: List<Problem>) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(problem.size) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(ItemBackground)
                    .padding(10.dp),

                ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Problem: ${problem[it].name}",
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            letterSpacing = letterSpacing,
                            lineHeight = lineHeight,
                        )
                    )
                    if (problem[it].medications.isNotEmpty()) {
                        Text(
                            text = "medication: ${problem[it].medications[0].name}",
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                color = Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = letterSpacing,
                                lineHeight = lineHeight,
                            )
                        )

                        Text(
                            text = "dose: ${problem[it].medications[0].dose}",
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                color = Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = letterSpacing,
                                lineHeight = lineHeight,
                            )
                        )

                        Text(
                            text = "strength: ${problem[it].medications[0].strength}",
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                color = Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.SansSerif,
                                letterSpacing = letterSpacing,
                                lineHeight = lineHeight,
                            )
                        )

                    }


                }

            }
        }
    }
}