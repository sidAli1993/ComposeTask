package com.sid_ali_tech.composetask.data.remote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord


@Dao
interface HealthRecDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
fun insert(dtoHealthRecord: DTOHealthRecord)

@Query("SELECT * FROM healthRecord")
fun getAllModels():List<DTOHealthRecord>

}