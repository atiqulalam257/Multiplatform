package com.atiq.mp.core

import androidx.compose.ui.graphics.ImageBitmap
import com.seiko.imageloader.Image

expect fun Image.toComposeImageBitmap(): ImageBitmap