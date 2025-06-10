package com.atiq.mp.core

import com.seiko.imageloader.Image
import com.seiko.imageloader.model.ImageResult

actual fun ImageResult.Image.toImage(): Image = this.image