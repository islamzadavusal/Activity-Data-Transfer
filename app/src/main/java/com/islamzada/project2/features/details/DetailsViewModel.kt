package com.islamzada.project2.features.details

import androidx.lifecycle.MutableLiveData

class DetailsViewModel {

    val name = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun newProductAdded(){
        name.postValue("")
        code.postValue("")
        description.postValue("")

    }


}