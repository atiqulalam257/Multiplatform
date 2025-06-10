package com.atiq.mp.core

import com.atiq.mp.Holder
import com.atiq.mp.core.PlatformContext
import platform.UIKit.UIActivityViewController

actual fun share(context: PlatformContext, text: String) {
    val controller = UIActivityViewController(listOf(text), null)

    Holder.viewController?.presentViewController(controller, true, null)
}