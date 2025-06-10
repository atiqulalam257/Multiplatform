package com.atiq.mp.domain.movie

data class NowPlayingMovie(val movieId: Int,
                           val releaseDate: String,
                           val voteAverage: Double,
                           val title: String,
                           val posterPath: String
)