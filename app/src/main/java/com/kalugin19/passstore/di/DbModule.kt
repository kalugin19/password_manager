package com.kalugin19.passstore.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kalugin19.passstore.db.dao.PassDb
import com.kalugin19.passstore.db.dao.PassDbCallback
import com.kalugin19.passstore.db.dao.RecordsDao
import com.kalugin19.passstore.db.dao.ServiceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.GlobalScope
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Singleton
    @Provides
    fun provideDbCallback(@ApplicationContext context: Context): RoomDatabase.Callback {
        return PassDbCallback(context)
    }

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext context: Context,
        dbCallback: RoomDatabase.Callback
    ): PassDb {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("passmanager".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            PassDb::class.java,
            PassDb.DB_NAME
        )
            .addCallback(dbCallback)
            .openHelperFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    fun provideRecordsDao(database: PassDb): RecordsDao {
        return database.recordsDao()
    }

    @Singleton
    @Provides
    fun provideServiceDao(database: PassDb): ServiceDao {
        return database.serviceDao()
    }
}