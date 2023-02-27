package com.pico.crypto.presentation.coin_detail

import com.pico.crypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val coin: CoinDetail? = null
)
