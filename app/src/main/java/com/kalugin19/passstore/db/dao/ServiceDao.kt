package com.kalugin19.passstore.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.kalugin19.passstore.db.enteties.Service

@Dao
interface ServiceDao {

    @Insert
    suspend fun insert(vararg services: Service)

}