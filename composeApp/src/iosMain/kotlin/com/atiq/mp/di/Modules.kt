package com.atiq.mp.di

import com.atiq.mp.core.IosLocationRepository
import com.atiq.mp.data.KVaultSettingsProvider
import com.atiq.mp.domain.location.LocationRepository
import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.di.NameSessionSettings
import com.liftric.kvault.KVault
import org.koin.dsl.module

actual val settingsModule = module {
    single {
        SessionSettings(
            KVaultSettingsProvider(KVault(NameSessionSettings))
        )
    }
}
actual val locationModule = module {
    single<LocationRepository> { IosLocationRepository() }
}
