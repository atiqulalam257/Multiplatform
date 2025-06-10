package com.atiq.mp.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.atiq.mp.store

@Composable
actual fun BackHandler(isEnabled: Boolean, onBack: () -> Unit) {
    LaunchedEffect(isEnabled) {
        store.events.collect {
            if (isEnabled) {
                onBack()
            }
        }
    }
}
