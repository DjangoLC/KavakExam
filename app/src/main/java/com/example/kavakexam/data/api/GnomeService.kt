package com.example.kavakexam.data.api

import retrofit2.Response
import retrofit2.http.GET

interface GnomeService {

    @GET("rrafols/mobile_test/master/data.json")
    suspend fun getGnomes(): Response<GnomeResponse>

}