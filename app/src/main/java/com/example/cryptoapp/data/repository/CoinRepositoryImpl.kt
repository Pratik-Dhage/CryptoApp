package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.data_transfer_object.CoinDetailDto
import com.example.cryptoapp.data.remote.data_transfer_object.CoinDto
import com.example.cryptoapp.data.remote.data_transfer_object.CoinPaprikaApi
import com.example.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(

    private val api : CoinPaprikaApi ) : CoinRepository
{
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return api.getCoinById(coinId)
    }
}