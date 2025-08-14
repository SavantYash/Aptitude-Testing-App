package com.example.aptitude1.retrofit
import com.example.aptitude1.model.QuestionList1
import retrofit2.Response
import retrofit2.http.GET

interface QuestionApi {

    @GET("/question")
    suspend fun getQuestions() : Response<QuestionList1>

}