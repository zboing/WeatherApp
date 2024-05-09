package com.weather.alerts.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.alerts.api.RetrofitBuilder.apiService
import com.weather.alerts.interfaces.UiState
import com.weather.alerts.models.Features
import com.weather.alerts.models.Root
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel : ViewModel() {
    private val uiState = MutableLiveData<UiState<List<Features>>>()

    fun getUiState(): LiveData<UiState<List<Features>>> {
        return uiState
    }

    init {
        //getData()
    }

    fun getData() {
        uiState.postValue(UiState.Loading)
        viewModelScope.launch {
            apiService.getData().enqueue(object : Callback<Root> {
                override fun onResponse(call: Call<Root>, response: Response<Root>) {
                    //Log.d(TAG,"getData "+response)
                    if (response.isSuccessful) {
                        uiState.postValue(UiState.Success(response.body()?.features?.toList() ?: emptyList()))
                    } else {
                        //Log.d(TAG,"getData not succesfull "+response)
                        uiState.postValue(UiState.Error("Response not successful!"))
                    }
                }

                override fun onFailure(call: Call<Root>, t: Throwable) {
                    //Log.d(TAG,"getData onFailure "+t.message+t.toString())
                    uiState.postValue(UiState.Error(t.toString()))
                }
            })
        }
    }

    companion object {
        private const val TAG = "@@@"
    }
}