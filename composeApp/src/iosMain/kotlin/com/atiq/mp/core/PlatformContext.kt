package com.atiq.mp.core

import androidx.compose.runtime.Composable
import com.atiq.mp.core.PlatformContext

actual class PlatformContext

@Composable
actual fun getPlatformContext(): PlatformContext = com.atiq.mp.core.PlatformContext()