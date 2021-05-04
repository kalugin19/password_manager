package com.kalugin19.passstore.di

import androidx.lifecycle.ViewModelProvider
import com.kalugin19.passstore.factories.AddRecordsViewModelFactory
import com.kalugin19.passstore.factories.AddViewModelFactoryQualifier
import com.kalugin19.passstore.factories.RecordsViewModelFactory
import com.kalugin19.passstore.factories.RecordsViewModelFactoryQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelsFactoriesModule {

    @Binds
    @AddViewModelFactoryQualifier
    abstract fun bindAddRecordViewModelFactory(
        factory: AddRecordsViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @RecordsViewModelFactoryQualifier
    abstract fun bindAddViewModelFactory(
        factory: RecordsViewModelFactory
    ): ViewModelProvider.Factory
}