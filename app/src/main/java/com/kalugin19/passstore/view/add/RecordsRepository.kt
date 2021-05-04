package com.kalugin19.passstore.view.add

import com.kalugin19.passstore.db.enteties.Record
import kotlinx.coroutines.flow.Flow

interface RecordsRepository {

    suspend fun save(login: String, password: String)

    fun getAll(): Flow<List<Record>>

}