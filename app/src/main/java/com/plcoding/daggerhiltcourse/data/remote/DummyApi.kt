package com.plcoding.daggerhiltcourse.data.remote

import retrofit2.http.GET

interface DummyApi {

    @GET("test")
    suspend fun doNetworkCall()
}