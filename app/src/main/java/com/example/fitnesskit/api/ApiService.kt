package com.example.fitnesskit.api

import com.example.fitnesskit.data.Training
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("schedule/get_v3/?club_id=2")
    suspend fun getTrainingList(): Response<Training>
}