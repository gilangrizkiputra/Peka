package com.sukasrana.peka.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sukasrana.peka.model.Balita
import com.sukasrana.peka.network.RetrofitInstance
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Balita>>()
    val data: LiveData<List<Balita>> get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getBalita()
                _data.value = response
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
