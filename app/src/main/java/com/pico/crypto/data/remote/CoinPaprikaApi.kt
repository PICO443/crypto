package com.pico.crypto.data.remote

import com.pico.crypto.data.remote.dto.CoinDetailDto
import com.pico.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    fun getCoin(@Path("coinId") coinId: String): CoinDetailDto
}