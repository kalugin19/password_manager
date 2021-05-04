package com.kalugin19.passstore.di

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module
object NavigationModule {

    @Provides
    fun provideNavigator(@FragmentScoped fragment: Fragment): NavController {
        return fragment.findNavController()
    }
}