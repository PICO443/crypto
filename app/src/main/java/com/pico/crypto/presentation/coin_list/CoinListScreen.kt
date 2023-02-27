package com.pico.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pico.crypto.presentation.Screens
import com.pico.crypto.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Box(modifier = modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        LazyColumn() {
            items(state.value.data) { coin ->
                CoinListItem(modifier = Modifier.padding(vertical = 16.dp),coin = coin, onCoinClick = {
                    navController.navigate(Screens.CoinDetailScreen.route + "/${coin.id}")
                })
            }
        }
        if (state.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier)
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

@Preview(showSystemUi = true)
@Composable
fun CoinLIstPreview(){
    MaterialTheme() {

    }
}