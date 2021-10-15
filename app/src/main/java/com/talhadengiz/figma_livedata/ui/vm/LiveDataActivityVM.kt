package com.talhadengiz.figma_livedata.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*


class LiveDataActivityVM : ViewModel() {

    private var currentDate: MutableLiveData<String>? = MutableLiveData()

    fun getCurrentDate(): MutableLiveData<String>? {
        if (currentDate == null) {
            currentDate = loadCurrentDate()
        }
        return currentDate
    }

    private fun loadCurrentDate(): MutableLiveData<String>? {
        val liveData = MutableLiveData<String>()
        liveData.value = Date().toString()
        return liveData
    }
}