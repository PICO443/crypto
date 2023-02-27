package com.pico.crypto.presentation

sealed class Screens(val route: String){
    object CoinListScreen: Screens("Coin_list_screen")
    object CoinDetailScreen: Screens("Coin_detail_screen")
}
