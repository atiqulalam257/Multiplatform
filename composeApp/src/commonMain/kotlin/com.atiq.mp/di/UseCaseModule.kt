package com.atiq.mp.di

import com.atiq.mp.domain.account.GetAccountDetailUseCase
import com.atiq.mp.domain.account.LogoutUseCase
import com.atiq.mp.domain.favorite.AddFavoriteUseCase
import com.atiq.mp.domain.favorite.GetMovieStateUseCase
import com.atiq.mp.domain.favorite.GetTvStateUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetAccountDetailUseCase(get()) }
    factory { LogoutUseCase(get(), get()) }
    factory { AddFavoriteUseCase(get()) }
    factory { GetMovieStateUseCase(get()) }
    factory { GetTvStateUseCase(get()) }
}
