package com.atiq.mp.di

import com.atiq.mp.ui.scene.login.LoginViewModel
import com.atiq.mp.ui.scene.account.AccountDetailViewModel
import com.atiq.mp.ui.scene.account.favoritescreen.FavoriteViewModel
import com.atiq.mp.ui.scene.main.MainViewModel
import com.atiq.mp.ui.scene.splashscreen.SplashViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { SplashViewModel(get()) }
    factory { MainViewModel() }
    factory { LoginViewModel(get(), get(), get()) }
    factory { FavoriteViewModel(get(), get()) }
    factory { AccountDetailViewModel(get(), get()) }
}
