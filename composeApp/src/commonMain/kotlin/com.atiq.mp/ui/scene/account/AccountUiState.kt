package com.atiq.mp.ui.scene.account

import com.atiq.mp.domain.account.AccountDetail
import com.atiq.mp.domain.favorite.FavoriteMovie
import com.atiq.mp.domain.favorite.FavoriteTv

data class AccountUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val accountData: AccountDetail = AccountDetail()
)

data class FavoriteMovieUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val favoriteMovieData: List<FavoriteMovie> = emptyList()
)

data class FavoriteTvUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val favoriteTvData: List<FavoriteTv> = emptyList()
)

fun AccountDetail(): AccountDetail = AccountDetail(0, "", "", "")

