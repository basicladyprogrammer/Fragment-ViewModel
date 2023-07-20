package com.example.myapp_fragmentandviewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var result = MutableLiveData<Double>()

    fun add(number1:Double, number2:Double){
//        var _result = number1.plus(number2)
//        result.value = _result

        result.value = number1.plus(number2)
    }
}