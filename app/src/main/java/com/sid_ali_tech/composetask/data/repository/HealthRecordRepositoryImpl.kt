package com.sid_ali_tech.composetask.data.repository

import com.sid_ali_tech.composetask.common.Response
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import com.sid_ali_tech.composetask.data.remote.AppDatabase
import com.sid_ali_tech.composetask.domain.repository.HealthRecordRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

class HealthRecordRepositoryImpl @Inject constructor(private val appDatabase: AppDatabase):HealthRecordRepository {
    override fun saveRec(dtoHealthRecord: DTOHealthRecord): Flow<Response<Boolean>> = channelFlow {
        try {
            trySend(Response.Loading)

            appDatabase.getHealthRecordDao().insert(dtoHealthRecord)
            trySend(Response.Success(true))


        }catch (e:Exception){
            trySend(Response.Error("error details ${e.message}"))
        }
        awaitClose()
    }

    override fun getAllHealthRec(): Flow<Response<List<DTOHealthRecord>>> = channelFlow{
        try {
            trySend(Response.Loading)

            val records=appDatabase.getHealthRecordDao().getAllModels()

            trySend(Response.Success(records))

        }catch (e:Exception){
            trySend(Response.Error("error details ${e.message}"))
        }
        awaitClose()
    }
}