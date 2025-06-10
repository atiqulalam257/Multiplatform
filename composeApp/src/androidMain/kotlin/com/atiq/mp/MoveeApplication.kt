package com.atiq.mp

import android.app.Application

class MoveeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.init()
    }
}
