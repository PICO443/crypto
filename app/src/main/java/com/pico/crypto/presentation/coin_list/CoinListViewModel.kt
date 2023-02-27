package com.pico.crypto.presentation.coin_list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pico.crypto.common.Resource
import com.pico.crypto.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(val getCoinsUseCase: GetCoinsUseCase): ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach {
            _state.value = when(it){
                is Resource.Error -> {
                    CoinListState(errorMessage = it.message ?: "An unexpected error happened")
                }
                is Resource.Loading -> {
                    CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    CoinListState(data = it.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}