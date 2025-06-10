package com.atiq.mp.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.atiq.mp.core.BackHandler
import com.atiq.mp.core.viewModel
import com.atiq.mp.domain.MediaType
import com.atiq.mp.ui.scene.account.favoritescreen.FavoriteViewModel
import com.atiq.mp.ui.scene.account.favoritescreen.FavoriteScreen

class FavoriteScreen(private val mediaType: MediaType) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: FavoriteViewModel = viewModel()

        FavoriteScreen(
            viewModel = viewModel,
            mediaType = mediaType,
            navigateToMovie = { /*navigator.push(MovieDetailScreen(it))*/ },
            navigateToTv = { /*navigator.push(TvDetailScreen(it))*/ },
            navigateBack = { navigator.pop() }
        )

        BackHandler(isEnabled = true) {
            navigator.pop()
        }
    }
}
