package com.atiq.mp.ui.scene.account.favoritescreen

import com.atiq.mp.core.ViewModel
import com.atiq.mp.core.viewModelScope
import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.domain.favorite.FavoriteRepository
import com.atiq.mp.ui.scene.account.FavoriteMovieUiState
import com.atiq.mp.ui.scene.account.FavoriteTvUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoriteRepository: FavoriteRepository,
    private val sessionSettings: SessionSettings
) : ViewModel {

    private val _favoriteMovieUiState = MutableStateFlow(FavoriteMovieUiState())
    val favoriteMovieUiState: StateFlow<FavoriteMovieUiState> = _favoriteMovieUiState

    private val _favoriteTvUiState = MutableStateFlow(FavoriteTvUiState())
    val favoriteTvUiState: StateFlow<FavoriteTvUiState> = _favoriteTvUiState


    fun getPopularMovie() {
        viewModelScope.launch {
            val result = favoriteRepository.getFavoriteMovie(
                accountId = sessionSettings.getAccountId() ?: 0,
                sessionId = sessionSettings.getSessionId() ?: ""
            )
            if (result.isSuccess) {
                _favoriteMovieUiState.update { favoriteMovie ->
                    favoriteMovie.copy(
                        isLoading = false,
                        favoriteMovieData = result.getOrDefault(listOf())
                    )
                }
            }
        }
    }

    fun getPopularTv() {
        viewModelScope.launch {
            val result = favoriteRepository.getFavoriteTv(
                accountId = sessionSettings.getAccountId() ?: 0,
                sessionId = sessionSettings.getSessionId() ?: ""
            )
            if (result.isSuccess) {
                _favoriteTvUiState.update { favoriteMovie ->
                    favoriteMovie.copy(
                        isLoading = false,
                        favoriteTvData = result.getOrDefault(listOf())
                    )
                }
            }
        }
    }
}
