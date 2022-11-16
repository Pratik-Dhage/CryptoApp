package com.example.cryptoapp.dependency_injection

import com.example.cryptoapp.common.Constants
import com.example.cryptoapp.data.remote.data_transfer_object.CoinPaprikaApi
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // it means dependencies in module will Live until this App is Active
object AppModule {

    @Provides
    @Singleton // means single instance throughout the app
fun providePaprikaApi() : CoinPaprikaApi{

    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)
}

    @Provides
    @Singleton // means single instance throughout the app
fun provideCoinRepository(api : CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
}
}