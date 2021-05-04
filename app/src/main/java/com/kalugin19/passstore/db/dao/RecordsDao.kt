package com.kalugin19.passstore.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kalugin19.passstore.db.enteties.Record
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordsDao {

    @Insert
    suspend fun save(record: Record)

    @Query("SELECT * FROM record")
    fun getRecords() : Flow<List<Record>>

}