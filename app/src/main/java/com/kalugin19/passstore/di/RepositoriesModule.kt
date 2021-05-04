package com.kalugin19.passstore.di

import com.kalugin19.passstore.view.add.RecordsRepository
import com.kalugin19.passstore.view.add.RecordsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoriesModule {

    @Binds
    fun bindRecordsRepository(recordsRepository: RecordsRepositoryImpl) : RecordsRepository

}