package com.example.aptitude1.model

import com.example.aptitude1.retrofit.QuestionApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchData {
    private val api: QuestionApi

    init {
        api = Retrofit.Builder()
            .baseUrl("http://172.29.232.47:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }

    fun getApi(): QuestionApi = api
}
