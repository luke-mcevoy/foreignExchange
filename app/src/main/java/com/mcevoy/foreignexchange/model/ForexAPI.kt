package com.mcevoy.foreignexchange.model

import io.reactivex.Single
import retrofit2.http.GET

interface ForexAPI {
    @GET()
    fun getForexRate(): Single<List<ForexResponse>>
}