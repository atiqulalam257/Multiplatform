package com.atiq.mp.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.atiq.mp.core.viewModel
import com.atiq.mp.ui.scene.login.LoginViewModel
import com.atiq.mp.ui.scene.login.LoginScreen

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: LoginViewModel = viewModel()

        LoginScreen(
            viewModel = viewModel,
            navigateToWebViewScreen = { navigator.push(WebViewScreen(it)) },
            navigateToMainScreen = { navigator.replace(MainScreen()) }
        )
    }
}
