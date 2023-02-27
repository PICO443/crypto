package com.pico.crypto.domain.use_case.get_coins

import com.pico.crypto.common.Resource
import com.pico.crypto.data.remote.dto.toCoin
import com.pico.crypto.domain.model.Coin
import com.pico.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coins = coinRepository.getCoins().map { it.toCoin() }
                emit(Resource.Success(coins))
            } catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected Error happened."))
            } catch (e: IOException){
                emit(Resource.Error("Couldn't react the server. Check your internet connection."))
            }
        }
    }
}