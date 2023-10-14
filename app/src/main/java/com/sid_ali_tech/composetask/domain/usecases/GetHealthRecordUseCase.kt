package com.sid_ali_tech.composetask.domain.usecases

import com.sid_ali_tech.composetask.common.Response
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import com.sid_ali_tech.composetask.domain.repository.HealthRecordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHealthRecordUseCase @Inject constructor(private val healthRecordRepository: HealthRecordRepository){
    operator fun invoke():Flow<Response<List<DTOHealthRecord>>>{
        return healthRecordRepository.getAllHealthRec()
    }
}