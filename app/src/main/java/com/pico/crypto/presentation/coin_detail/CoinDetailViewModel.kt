package com.pico.crypto.presentation.coin_detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.crypto.common.Constants.PARAM_COIN_ID
import com.pico.crypto.common.Resource
import com.pico.crypto.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach {
            _state.value = when (it) {
                is Resource.Error -> {
                    CoinDetailState(errorMessage = it.message ?: "An unexpected error happened")
                }
                is Resource.Loading -> {
                    CoinDetailState(isLoading = true)
                }
                is Resource.Success -> {
                    CoinDetailState(coin = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}