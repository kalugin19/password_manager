package com.kalugin19.passstore.db.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record")
data class Record(
        @PrimaryKey(autoGenerate = true)
        var id: Long? = null,
        val login: String,
        val password: String
) {
    private val recordId: Long
        get() = id!!
}