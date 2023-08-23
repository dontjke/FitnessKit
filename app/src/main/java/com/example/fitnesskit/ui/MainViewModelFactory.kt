package com.example.fitnesskit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnesskit.api.ApiService

class MainViewModelFactory constructor(
    private val retrofit: ApiService
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelTraining::class.java)) {
            return ViewModelTraining(retrofit) as T
        }
        throw java.lang.IllegalArgumentException("Unknown class name")
    }
}