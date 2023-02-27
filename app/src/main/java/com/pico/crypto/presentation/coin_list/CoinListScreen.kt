package com.pico.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Box(modifier = modifier) {
        LazyColumn(){
            items(state.value.data){ coin ->
                CoinListItem(coin = coin, onCoinClick = {
                    navController.navigate(Screens.CoinListScreen().route + "/${coin.id}")
                })
            }
        }
    }
}