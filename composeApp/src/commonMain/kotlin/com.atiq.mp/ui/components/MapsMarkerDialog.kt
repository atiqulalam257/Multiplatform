package com.atiq.mp.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atiq.mp.ui.theme.Fonts
import multiplateform.composeapp.generated.resources.Res
import multiplateform.composeapp.generated.resources.go
import org.jetbrains.compose.resources.stringResource

@Composable
fun MapsMarkerDialog(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 88.dp
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        TextItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = Int.MAX_VALUE
        )
        TextItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 5.dp),
            text = subTitle,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            maxLines = Int.MAX_VALUE
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.secondaryContainer
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(11.dp),
            contentPadding = PaddingValues(0.dp),
            onClick = {
                onClick.invoke()
            }) {
            Icon(
                modifier = Modifier.padding(2.dp),
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                tint = Color.White,
                contentDescription = null
            )
            TextItem(
                modifier = Modifier.wrapContentSize(),
                fontSize = 10.sp,
                fontFamily = Fonts.medium,
                textColor = MaterialTheme.colorScheme.primaryContainer,
                text = stringResource(Res.string.go),
            )
        }
    }
}
