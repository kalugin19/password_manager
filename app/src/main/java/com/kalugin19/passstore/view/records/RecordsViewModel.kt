package com.kalugin19.passstore.view.records

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kalugin19.passstore.db.enteties.Record
import com.kalugin19.passstore.view.add.RecordsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordsViewModel @Inject constructor(
    recordsRepository: RecordsRepository
) : ViewModel() {

    val records: LiveData<List<Record>> = recordsRepository.getAll().asLiveData()

}