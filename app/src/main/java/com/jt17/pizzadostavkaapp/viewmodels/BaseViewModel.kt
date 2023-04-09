package com.jt17.pizzadostavkaapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jt17.pizzadostavkaapp.models.MenuModel

class BaseViewModel : ViewModel() {
    val responseList = MutableLiveData<List<MenuModel>>()

}