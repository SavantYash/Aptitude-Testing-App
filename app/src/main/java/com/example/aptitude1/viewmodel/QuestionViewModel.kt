package com.example.aptitude1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aptitude1.model.FetchData
import com.example.aptitude1.model.QuetionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {

    private var _questionList = MutableStateFlow<List<QuetionModel>>(emptyList())
    val questionList : StateFlow<List<QuetionModel>> = _questionList

    fun getData(){
        viewModelScope.launch {
            val q = FetchData().getApi().getQuestions()

            try {
                if (q.isSuccessful) {
                    val json = q.body()?.data
                    _questionList.value = json!!
                    Log.d("SUCCESS", "getData: ${questionList.value}")
                }
            }catch(err : Exception){
                Log.d("ERROR123", "getData: $err")
            }
        }
    }

}