package com.sid_ali_tech.composetask.hilt

import android.content.Context
import com.sid_ali_tech.composetask.data.remote.AppDatabase
import com.sid_ali_tech.composetask.data.repository.HealthRecordRepositoryImpl
import com.sid_ali_tech.composetask.domain.HealthUseCases
import com.sid_ali_tech.composetask.domain.repository.HealthRecordRepository
import com.sid_ali_tech.composetask.domain.usecases.GetHealthRecordUseCase
import com.sid_ali_tech.composetask.domain.usecases.SaveHealthRecordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase(context)
    }

    @Provides
    fun providesHealthRecordRepository(appDatabase: AppDatabase): HealthRecordRepository {
        return HealthRecordRepositoryImpl(appDatabase)
    }

    @Provides
    fun providesHealthUseCases(healthRecordRepository: HealthRecordRepository): HealthUseCases {
        return HealthUseCases(
            saveHealthRecordUseCase = SaveHealthRecordUseCase(healthRecordRepository),
            getHealthRecordUseCase = GetHealthRecordUseCase(healthRecordRepository)
        )
    }
}



