package com.atiq.mp.core

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.atiq.mp.core.PlatformContext

actual class PlatformContext(val androidContext: Context)

@Composable
actual fun getPlatformContext(): PlatformContext {
    val context = LocalContext.current
    return remember(context) {
        PlatformContext(context)
    }
}

