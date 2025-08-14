package com.example.aptitude1.model

object QuestionList {

    private lateinit var _question : List<QuetionModel>

    val questions: List<QuetionModel> // public read-only getter
        get() = _question


    fun addQuestions( qList : List<QuetionModel>){
        _question = qList
    }
}