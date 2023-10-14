package com.sid_ali_tech.composetask.common

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sid_ali_tech.composetask.data.models.MyData

object MyDataConverter {
    @TypeConverter
    @JvmStatic
    fun fromMyData(myData: MyData): String {
        return Gson().toJson(myData)
    }

    @TypeConverter
    @JvmStatic
    fun toMyData(jsonString: String): MyData {
        return Gson().fromJson(jsonString, MyData::class.java)
    }
}