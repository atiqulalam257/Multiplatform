package com.atiq.mp.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.atiq.mp.core.viewModel
import com.atiq.mp.ui.tab.TabItem
import com.atiq.mp.ui.scene.main.MainScreen

class MainScreen : Screen {

    @Composable
    override fun Content() {
        TabNavigator(TabItem.MoviesTab().tab, true) { navigator ->
            MainScreen(
                viewModel = viewModel(),
                isTabSelected = {
                    navigator.current.key == it.key
                },
                onTabSelected = {
                    navigator.current = it.tab
                }
            )
        }
    }
}
