package com.atiq.mp.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.atiq.mp.core.viewModel
import com.atiq.mp.ui.scene.splashscreen.SplashViewModel
import com.atiq.mp.ui.scene.splashscreen.SplashScreen

class SplashScreen : Screen {

    @Composable
    override fun Content() { //todo splash api

        val navigator = LocalNavigator.currentOrThrow
        val viewModel: SplashViewModel = viewModel()

        SplashScreen(
            viewModel = viewModel,
            navigateToLogin = { navigator.replace(LoginScreen()) },
            navigateToMain = { navigator.replace(MainScreen()) }
        )
    }
}
