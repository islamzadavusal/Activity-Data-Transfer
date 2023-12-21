package com.islamzada.project2.features.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val desc = MutableLiveData<String>()
}
