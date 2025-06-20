package com.atiq.mp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import multiplateform.composeapp.generated.resources.Res
import multiplateform.composeapp.generated.resources.ic_arrow_back
import multiplateform.composeapp.generated.resources.ic_heart
import multiplateform.composeapp.generated.resources.ic_heart_filled
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreensAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {
    Box {
        content()
        TopAppBar(
            modifier = modifier.align(Alignment.TopCenter),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            title = { TextItem(text = title ?: "") },
            navigationIcon = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (leadingIcon != null) {
                        leadingIcon()
                    }
                    if (trailingIcon != null) {
                        trailingIcon()
                    }
                }
            }
        )
    }
}

@Composable
fun BackPressedItem(modifier: Modifier = Modifier, onBackPressed: () -> Unit) {
    Surface(
        modifier = modifier.padding(start = 24.dp).size(35.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .clickable(onClick = onBackPressed)
                .padding(7.dp),
            painter = painterResource(Res.drawable.ic_arrow_back),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primaryContainer
        )
    }
}

@Composable
fun FavouriteItem(
    modifier: Modifier = Modifier,
    isFavorite: Boolean = false,
    onFavouriteClicked: () -> Unit = {}
) {
    Surface(
        modifier = modifier.padding(end = 24.dp).size(35.dp),
        shape = CircleShape,
        color = MaterialTheme.colorScheme.primaryContainer
    ) {

        IconButton(
            onClick = {
                onFavouriteClicked()
            }
        ) {
            Icon(
                modifier = Modifier
                    .padding(6.dp),
                painter = painterResource(if (isFavorite) Res.drawable.ic_heart_filled else Res.drawable.ic_heart),
                contentDescription = null,
                tint = if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
            )
        }

    }
}
