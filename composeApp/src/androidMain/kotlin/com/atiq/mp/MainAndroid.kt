package com.atiq.mp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.atiq.mp.di.init
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@Composable
fun MainView() {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(context.applicationContext)
        init()
    }) {
        App()
    }
}
