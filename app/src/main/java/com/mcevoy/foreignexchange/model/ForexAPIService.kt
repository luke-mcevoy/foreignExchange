package com.mcevoy.foreignexchange.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ForexAPIService {

    private var BASE_URL = "https://api.ratesapi.io/api/latest"

    private var API = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ForexAPI::class.java)

    fun getForexRate(): Single<List<ForexResponse>> {
        return API.getForexRate()
    }
}