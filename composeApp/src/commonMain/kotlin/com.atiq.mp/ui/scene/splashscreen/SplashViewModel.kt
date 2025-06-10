package com.atiq.mp.ui.scene.splashscreen

import com.atiq.mp.core.ViewModel
import com.atiq.mp.domain.account.AccountRepository

class SplashViewModel(
    repository: AccountRepository
) : ViewModel {
    val isLoggedIn = repository.getLoginState()
}
