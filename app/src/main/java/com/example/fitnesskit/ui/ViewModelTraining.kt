package com.example.fitnesskit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnesskit.api.ApiResult
import com.example.fitnesskit.api.ApiService
import com.example.fitnesskit.data.Training
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelTraining(private val retrofit: ApiService) : ViewModel() {

    var liveData = MutableLiveData<ApiResult<Training>>()

    init {
        loadListTraining()
    }

    fun loadListTraining() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = retrofit.getTrainingList()
            if (result.isSuccessful) {
                liveData.postValue(ApiResult.Success(result.body()))
            } else liveData.postValue(ApiResult.Error("Not Loading"))
        }
    }

    fun getTrainerById(id: String): String {
        val trainer = liveData.value?.data?.trainers?.find {
            it.id == id
        }
        return trainer?.name ?: " "
    }
}