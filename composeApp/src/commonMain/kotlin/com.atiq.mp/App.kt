package com.atiq.mp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.atiq.mp.nav.LocalMainNavigator
import com.atiq.mp.nav.SplashScreen
import com.atiq.mp.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Navigator(SplashScreen()) {
            CompositionLocalProvider(LocalMainNavigator provides it) {
                CurrentScreen()
            }
        }

        LaunchedEffect(Unit) {
            log { "App started." }
        }
    }
}
