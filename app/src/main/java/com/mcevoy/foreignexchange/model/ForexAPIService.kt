package com.mcevoy.foreignexchange.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ForexAPIService {

    private var API_ACCESS_KEY = "4cbfc042478a3c5440c9d4b2be582443"
    private var BASE = "USD"
    private var SYMBOLS = "GBP,JPY,EUR"
    private var BASE_URL = "http://data.fixer.io/api/latest?$API_ACCESS_KEY&$BASE&$SYMBOLS"

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