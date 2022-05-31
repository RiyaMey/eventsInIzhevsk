package com.example.vkeventsinizhevsk.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkeventsinizhevsk.network.Event
import com.example.vkeventsinizhevsk.network.VkApi
import kotlinx.coroutines.launch
import java.lang.Exception

class EventListViewModel: ViewModel() {
    private var _dataSet = MutableLiveData<List<Event>>()
    val dataSet: LiveData<List<Event>>
        get() = _dataSet

    private var _startDate = MutableLiveData<String>("")
    val startDate: LiveData<String>
        get() = _startDate

    private var _endDate = MutableLiveData<String>("")
    val endDate: LiveData<String>
        get() = _endDate

    init {
        getDataSet()
    }
    fun getDataSet() {
        // TODO: запрос при изменении дат
        viewModelScope.launch {
            try {
                val r = VkApi.retrofitService.getEvents()
                Log.d("tag", "response ${r.toString()}")

            } catch (e: Exception) {
                Log.e("tag", "response error ${e.toString()}")

            }
        }
//        _dataSet.value = EventsSourse().loadEvents()
    }

    fun readDataSet() {
        // TODO: read from storage
    }

    /**
     * Sets a new value for the start date field
     */
    fun setNewStartDate(newDate: String) {
        _startDate.value = newDate
        getDataSet()
    }

    /**
     * Sets a new value for the end date field
     */
    fun setNewEndDate(newDate: String) {
        _endDate.value = newDate
        getDataSet()
    }
}