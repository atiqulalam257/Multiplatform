package com.atiq.mp.di

import com.atiq.mp.data.account.AccountRepositoryImpl
import com.atiq.mp.data.favorite.FavoriteRepositoryImpl
import com.atiq.mp.domain.account.AccountRepository
import com.atiq.mp.domain.favorite.FavoriteRepository
import com.atiq.mp.domain.movie.MovieRepository
import com.atiq.mp.domain.tv.TvRepository
import com.atiq.mp.data.movie.MovieRepositoryImpl
import com.atiq.mp.domain.artist.ArtistRepository
import com.example.moveeapp_compose_kmm.data.artist.ArtistRepositoryImpl
import com.atiq.mp.data.tv.TvRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<AccountRepository> { AccountRepositoryImpl(get(), get()) }
    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<TvRepository> { TvRepositoryImpl(get(), get()) }
    single<ArtistRepository> { ArtistRepositoryImpl(get()) }
    single<AccountRepository> { AccountRepositoryImpl(get(), get()) }
    single<FavoriteRepository> { FavoriteRepositoryImpl(get(), get()) }

}
