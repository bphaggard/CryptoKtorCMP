package org.example.project.ktorapitestcmp.presentation.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ktorapitestcmp.composeapp.generated.resources.Res
import ktorapitestcmp.composeapp.generated.resources.czech_republic
import ktorapitestcmp.composeapp.generated.resources.european_union
import ktorapitestcmp.composeapp.generated.resources.united_kingdom
import ktorapitestcmp.composeapp.generated.resources.united_states
import org.jetbrains.compose.resources.painterResource

@Composable
fun CurrenciesCard(
    usLabel: String,
    ukLabel: String,
    euLabel: String,
    czLabel: String,
    usValue: String,
    ukValue: String,
    euValue: String,
    czValue: String
){
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier.height(38.dp),
                    painter = painterResource(Res.drawable.united_states),
                    contentDescription = "USA_logo"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "$usLabel in USD: "
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    maxLines = 1,
                    text = usValue
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier.height(38.dp),
                    painter = painterResource(Res.drawable.united_kingdom),
                    contentDescription = "UK_logo"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "$ukLabel in GBP: "
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    maxLines = 1,
                    text = ukValue
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier.height(38.dp),
                    painter = painterResource(Res.drawable.european_union),
                    contentDescription = "EUR_logo"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "$euLabel in EUR: "
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    maxLines = 1,
                    text = euValue
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier.height(38.dp),
                    painter = painterResource(Res.drawable.czech_republic),
                    contentDescription = "CZK_logo"
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "$czLabel in CZK: "
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    maxLines = 1,
                    text = czValue
                )
            }
        }
    }
}