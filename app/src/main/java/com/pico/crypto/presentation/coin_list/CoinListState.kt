package com.pico.crypto.presentation.coin_list

import com.pico.crypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val data: List<Coin> = emptyList()
)
