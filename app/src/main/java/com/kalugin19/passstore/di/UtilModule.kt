package com.kalugin19.passstore.di

import com.kalugin19.passstore.util.passgenerator.PasswordGenerator
import com.kalugin19.passstore.util.passgenerator.PasswordGeneratorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UtilModule {

    @Singleton
    @Binds
    abstract fun bindPasswordGenerator(passwordGenerator: PasswordGeneratorImpl) : PasswordGenerator

}