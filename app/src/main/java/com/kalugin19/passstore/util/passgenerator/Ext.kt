package com.kalugin19.passstore.util.passgenerator

import android.content.Context
import android.view.LayoutInflater


val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)