package com.atiq.mp.domain.favorite

data class FavoriteTv(
    val tvId: Int = 0,
    val voteAverage: Double = 0.0,
    val title: String = "",
    val posterPath: String = "",
)