package org.example.project.ktorapitestcmp.presentation.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.project.ktorapitestcmp.data.CryptoCurrency
import org.example.project.ktorapitestcmp.util.GetOswaldFontLightFamily
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AssetRow(
    asset: CryptoCurrency,
    image: DrawableResource,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(0.9f)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.15f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(image),
                    null,
                    modifier = Modifier.size(60.dp)
                )
            }
            Spacer(Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.85f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = asset.name,
                    fontFamily = GetOswaldFontLightFamily(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 26.sp
                )
            }
        }
    }
}