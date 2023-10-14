package com.sid_ali_tech.composetask.domain.repository

import com.sid_ali_tech.composetask.common.Response
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import kotlinx.coroutines.flow.Flow

interface HealthRecordRepository {

    fun saveRec(dtoHealthRecord: DTOHealthRecord):Flow<Response<Boolean>>

    fun getAllHealthRec():Flow<Response<List<DTOHealthRecord>>>
}