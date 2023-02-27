package com.pico.crypto.data.repository

import com.pico.crypto.data.remote.CoinPaprikaApi
import com.pico.crypto.data.remote.dto.CoinDetailDto
import com.pico.crypto.data.remote.dto.CoinDto
import com.pico.crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }

}