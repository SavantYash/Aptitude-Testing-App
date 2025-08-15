package com.example.aptitude1.retrofit
import com.example.aptitude1.model.QuestionListModel
import retrofit2.Response
import retrofit2.http.GET

interface QuestionApi {

    @GET("/question")
    suspend fun getQuestions() : Response<QuestionListModel>

}