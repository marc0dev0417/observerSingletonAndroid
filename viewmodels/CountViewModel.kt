package com.marc0dev.patternObserver.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    companion object{
        var countViewModel = CountViewModel()

        fun getInstance(): CountViewModel{
            if(countViewModel == null){
                countViewModel = CountViewModel()
            }
            return countViewModel
        }
    }

    private val currentCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(1)
    }

   fun incrementValue(){
        this.currentCount.value = currentCount.value?.plus(1)
    }
    fun decrementValue(){
        this.currentCount.value = currentCount.value?.dec()
    }

    fun getCurrentName(): LiveData<Int> {
        return this.currentCount
    }
}