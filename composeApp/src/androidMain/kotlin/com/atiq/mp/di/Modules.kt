package com.atiq.mp.di

import com.atiq.mp.core.AndroidLocationRepository
import com.atiq.mp.data.KVaultSettingsProvider
import com.atiq.mp.domain.account.SessionSettings
import com.atiq.mp.domain.location.LocationRepository

import com.liftric.kvault.KVault
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val settingsModule = module {
    single {
        SessionSettings(
            settingsProvider = KVaultSettingsProvider(
                KVault(androidContext(), NameSessionSettings)
            )
        )
    }
}


actual val locationModule = module {
    factory <LocationRepository> { AndroidLocationRepository(context = androidContext()) }
}
