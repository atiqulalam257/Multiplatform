package com.atiq.mp.core

import android.content.Intent
import com.atiq.mp.core.PlatformContext

actual fun share(context: PlatformContext, text: String) {

    val sendIntent: Intent = Intent().apply {
        setAction(Intent.ACTION_SEND)
        putExtra(Intent.EXTRA_TEXT, text)
        setType("text/plain")
    }
    val shareIntent = Intent.createChooser(sendIntent, null)

    context.androidContext.startActivity(shareIntent)
}