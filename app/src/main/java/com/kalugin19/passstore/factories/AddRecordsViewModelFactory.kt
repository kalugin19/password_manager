@file:Suppress("UNCHECKED_CAST")

package com.kalugin19.passstore.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kalugin19.passstore.view.add.AddRecordViewModel
import com.kalugin19.passstore.view.add.RecordsRepository
import javax.inject.Inject
import javax.inject.Qualifier

class AddRecordsViewModelFactory @Inject constructor(
    private val recordsRepository: RecordsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddRecordViewModel(recordsRepository) as T
    }
}

@Qualifier
annotation class AddViewModelFactoryQualifier

