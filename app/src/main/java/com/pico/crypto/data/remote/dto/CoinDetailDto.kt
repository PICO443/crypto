package com.pico.crypto.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.pico.crypto.domain.model.CoinDetail

data class CoinDetailDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    val is_new: Boolean,
    @SerializedName("last_data_at")
    val lastDataAt: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    @SerializedName("open_source")
    val openSource: Boolean,
    @SerializedName("org_structure")
    val orgStructure: String,
    @SerializedName("proof_type")
    val proofType: String,
    val rank: Int,
    @SerializedName("started_at")
    val startedAt: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<TeamMember>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id,
        name,
        description,
        isActive,
        rank,
        tags = tags.map { it.name },
        team,
        symbol
    )
}