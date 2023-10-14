package com.sid_ali_tech.composetask.domain

import com.sid_ali_tech.composetask.domain.usecases.GetHealthRecordUseCase
import com.sid_ali_tech.composetask.domain.usecases.SaveHealthRecordUseCase

data class HealthUseCases(
    val saveHealthRecordUseCase: SaveHealthRecordUseCase,
    val getHealthRecordUseCase: GetHealthRecordUseCase
)