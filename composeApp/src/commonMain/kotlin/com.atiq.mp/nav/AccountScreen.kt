package com.atiq.mp.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.atiq.mp.core.BackHandler
import com.atiq.mp.core.viewModel
import com.atiq.mp.ui.scene.account.AccountDetailViewModel
import com.atiq.mp.ui.scene.account.AccountScreen

class AccountScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val mainNavigator = LocalMainNavigator.current
        val viewModel: AccountDetailViewModel = viewModel()

        AccountScreen(
            viewModel = viewModel,
            navigateToSplash = { mainNavigator.replaceAll(SplashScreen()) },
            navigateToFavorite = { navigator.push(FavoriteScreen(it)) })

        BackHandler(isEnabled = true) {
            navigator.pop()
        }
    }
}
