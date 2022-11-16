package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.remote.data_transfer_object.CoinDetailDto
import com.example.cryptoapp.data.remote.data_transfer_object.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto
}