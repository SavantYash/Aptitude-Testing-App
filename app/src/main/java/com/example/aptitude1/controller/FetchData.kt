package com.example.aptitude1.controller

import android.util.Log
import com.example.aptitude1.model.QuestionList
import com.example.aptitude1.retrofit.QuestionApi
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchData {

    private val api : QuestionApi

    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://172.29.232.47:5000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(QuestionApi::class.java)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getQuestions(){
        GlobalScope.launch {
            try {
                val questions = api.getQuestions()
                if(questions.isSuccessful) {
                    val jsonString = questions.body()
//                    Log.d("SUCCESS", "getQuestions: ${jsonString?.message}")
                    QuestionList.addQuestions(jsonString?.questions!!)
                }
            }catch(err : Exception){
                Log.d("ERROR123","API error $err")
            }
        }
    }

}