package com.kalugin19.passstore.db.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "service")
data class Service(
    @PrimaryKey
    var id: Long? = null,
    val name: String,
    val imageRes: Int
)