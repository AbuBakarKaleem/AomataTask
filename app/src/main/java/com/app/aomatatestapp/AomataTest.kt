package com.app.aomatatestapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AomataTest : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}