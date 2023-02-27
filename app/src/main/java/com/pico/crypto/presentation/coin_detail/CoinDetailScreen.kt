package com.pico.crypto.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pico.crypto.presentation.coin_detail.components.TeamListItem

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Box(modifier = modifier) {
        state.value.coin?.let { coin ->
            LazyColumn() {
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Tags", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = coin.description)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Team Members", style = MaterialTheme.typography.titleMedium)
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        modifier = Modifier.fillMaxWidth(),
                        teamMember = teamMember
                    )
                    Divider()
                }
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator()
        }
        if (state.value.errorMessage.isNotBlank()) {
            Text(
                text = state.value.errorMessage,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}