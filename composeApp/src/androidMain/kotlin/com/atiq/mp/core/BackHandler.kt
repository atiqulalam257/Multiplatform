package com.atiq.mp.core

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun BackHandler(isEnabled: Boolean, onBack: () -> Unit) {
    BackHandler(isEnabled, onBack)
}