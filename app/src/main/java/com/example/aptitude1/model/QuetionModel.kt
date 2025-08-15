package com.example.aptitude1.model

data class QuetionModel(
    val id : Int = 0,
    val Question : String,
    val Options : List<String>,
    val Answer : String
)

data class QuestionListModel(
    val message : String,
    val data :  List<QuetionModel>
)
