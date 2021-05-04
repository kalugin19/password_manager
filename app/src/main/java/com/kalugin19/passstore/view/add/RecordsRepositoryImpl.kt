package com.kalugin19.passstore.view.add

import com.kalugin19.passstore.db.enteties.Record
import com.kalugin19.passstore.db.dao.RecordsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecordsRepositoryImpl @Inject constructor(
    private val recordsDao: RecordsDao
) : RecordsRepository {

    override suspend fun save(login: String, password: String) {
        val record = Record(
              login = login,
              password = password
        )
        recordsDao.save(record)
    }


    override fun getAll(): Flow<List<Record>> {
        return recordsDao.getRecords()
    }
}