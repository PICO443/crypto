package com.pico.crypto.domain.model

import com.pico.crypto.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val isActive: Boolean,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
    val symbol: String
)
