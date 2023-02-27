package com.pico.crypto.domain.repository

import com.pico.crypto.data.remote.dto.CoinDetailDto
import com.pico.crypto.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto
}