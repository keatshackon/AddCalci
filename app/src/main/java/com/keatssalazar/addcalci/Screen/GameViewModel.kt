package com.keatssalazar.addcalci.Screen

import android.util.Log
import android.util.MutableDouble
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel :ViewModel(){

    private val _res=MutableLiveData<Long>()
    val result:LiveData<Long>
    get() = _res

    init {
        Log.i("Keats","salazar")
        _res.value=0
    }
    fun calculate(a:Long,b:Long){
        _res.value=a+b
    }
}