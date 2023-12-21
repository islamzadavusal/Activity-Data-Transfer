package com.islamzada.project2.features.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var addProductObserver = MutableLiveData<Boolean>()

    fun onAddNewProduct(){
        addProductObserver.postValue(true)
    }

    }
