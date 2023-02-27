package com.pico.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pico.crypto.domain.model.Coin

@Composable
fun CoinListItem(modifier: Modifier = Modifier, coin: Coin, onCoinClick: (Coin) -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCoinClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})")
        Text(
            text = if (coin.isActive) "Is Active" else "Not Active",
            color = if (coin.isActive) Color.Green else Color.Red
        )
    }
}