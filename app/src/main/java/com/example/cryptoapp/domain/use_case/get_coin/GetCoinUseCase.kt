package com.example.cryptoapp.domain.use_case.get_coin

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.data.remote.data_transfer_object.toCoin
import com.example.cryptoapp.data.remote.data_transfer_object.toCoinDetail
import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class GetCoinUseCase @Inject constructor(

    private val repository : CoinRepository
) {
    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {

        try{
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }
        catch(e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Unexpected Error Occurred"))
        }
        catch(e : IOException){
         emit(Resource.Error<CoinDetail>(e.localizedMessage?:"Check Internet Connection"))
        }
    }
}