package com.kalugin19.passstore.db.dao

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kalugin19.passstore.R
import com.kalugin19.passstore.db.enteties.Service
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PassDbCallback @Inject constructor(
    private val application: Context
) : RoomDatabase.Callback() {

    private val serviceDao: ServiceDao by lazy {
        EntryPointAccessors.fromApplication(application, Dependencies::class.java).serviceDao()
    }

    override fun onCreate(db: SupportSQLiteDatabase) {
        populateDb()
    }


    private fun populateDb() {
        GlobalScope.launch(Dispatchers.IO) {
            serviceDao.insert(
                Service(name = "Facebook", imageRes = R.drawable.ic_facebook),
                Service(name = "Instagram", imageRes = R.drawable.ic_instagram),
                Service(name = "Twitter", imageRes = R.drawable.ic_twitter)
            )
        }
    }
}

@InstallIn(SingletonComponent::class)
@EntryPoint
interface Dependencies {
    fun serviceDao(): ServiceDao
}
