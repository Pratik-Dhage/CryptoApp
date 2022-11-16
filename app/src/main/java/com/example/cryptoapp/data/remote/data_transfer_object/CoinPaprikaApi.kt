package com.example.cryptoapp.data.remote.data_transfer_object

import com.example.cryptoapp.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId : String ) : CoinDetailDto
}