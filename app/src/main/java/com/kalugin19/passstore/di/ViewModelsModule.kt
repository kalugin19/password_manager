package com.kalugin19.passstore.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.kalugin19.passstore.R
import com.kalugin19.passstore.view.add.AddRecordViewModel
import com.kalugin19.passstore.factories.AddViewModelFactoryQualifier
import com.kalugin19.passstore.factories.RecordsViewModelFactoryQualifier
import com.kalugin19.passstore.view.records.RecordsViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module
object ViewModelsModule {


    @Provides
    fun provideAddRecordsViewModel(
        @FragmentScoped fragment: Fragment,
        @AddViewModelFactoryQualifier factory: ViewModelProvider.Factory
    ): AddRecordViewModel {
        return fragment.viewModels<AddRecordViewModel> { factory }.value
    }


    @Provides
    fun provideRecordsViewModel(
        @FragmentScoped fragment: Fragment,
        @RecordsViewModelFactoryQualifier factory: ViewModelProvider.Factory
    ): RecordsViewModel {
        return fragment.viewModels<RecordsViewModel> { factory }.value
    }

}