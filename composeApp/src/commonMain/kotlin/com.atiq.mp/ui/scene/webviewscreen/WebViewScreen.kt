package com.atiq.mp.ui.scene.webviewscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atiq.mp.core.WebView
import com.atiq.mp.ui.components.TransparentIconHolder

@Composable
fun WebViewContent(url: String, onBackPressed: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.height(70.dp)
                .fillMaxWidth()
                .background(color = Color.Black.copy(alpha = 0.6f)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TransparentIconHolder(
                icon = Icons.AutoMirrored.Rounded.ArrowBack,
                onClick = onBackPressed
            )
        }
        WebView(modifier = Modifier.fillMaxSize(), url)
    }
}
