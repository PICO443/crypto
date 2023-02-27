package com.pico.crypto.presentation

sealed class Screens(val route: String){
    class CoinListScreen(): Screens("Coin_list_screen")
    class CoinDetailScreen(): Screens("Coin_detail_screen")
}
