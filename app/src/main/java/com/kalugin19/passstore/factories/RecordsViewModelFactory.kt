package com.kalugin19.passstore.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kalugin19.passstore.view.add.RecordsRepository
import com.kalugin19.passstore.view.records.RecordsViewModel
import javax.inject.Inject
import javax.inject.Qualifier

class RecordsViewModelFactory @Inject constructor(
    private val recordsRepository: RecordsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecordsViewModel(recordsRepository) as T
    }
}

@Qualifier
annotation class RecordsViewModelFactoryQualifier
