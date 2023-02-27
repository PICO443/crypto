package com.pico.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pico.crypto.domain.model.Coin

@Composable
fun CoinListItem(modifier: Modifier = Modifier, coin: Coin, onCoinClick: (Coin) -> Unit) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .clickable { onCoinClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})", style = MaterialTheme.typography.titleMedium)
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(showSystemUi  = true)
@Composable
fun CoinListItemPreview(){
    MaterialTheme() {
        CoinListItem(coin = Coin(rank = 1, name = "Bitcoin", symbol = "BTC", isActive = true, id = "bitcoin"), onCoinClick = {})
    }
}