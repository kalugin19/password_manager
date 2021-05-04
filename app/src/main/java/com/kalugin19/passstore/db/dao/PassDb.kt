package com.kalugin19.passstore.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalugin19.passstore.db.enteties.Record
import com.kalugin19.passstore.db.enteties.Service

@Database(
    entities = [
        Record::class,
        Service::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PassDb : RoomDatabase() {

    abstract fun recordsDao(): RecordsDao

    abstract fun serviceDao(): ServiceDao

    companion object {
        const val DB_NAME = "pass_db"
    }
}