package com.sid_ali_tech.composetask.data.remote

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sid_ali_tech.composetask.common.MyDataConverter
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord

@androidx.room.Database(entities = [DTOHealthRecord::class], version = 1)
@TypeConverters(MyDataConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getHealthRecordDao(): HealthRecDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "myTask.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}