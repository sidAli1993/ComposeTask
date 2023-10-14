package com.sid_ali_tech.composetask.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.sid_ali_tech.composetask.common.MyDataConverter

@TypeConverters(MyDataConverter::class)
@Entity(tableName = "healthRecord")
data class DTOHealthRecord(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=0,
    @TypeConverters(MyDataConverter::class)
    val myData: MyData
)
