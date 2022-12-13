package com.jt17.bottomnavtest.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jt17.bottomnavtest.models.MenuModel

class BaseViewModel : ViewModel() {
    val responseList = MutableLiveData<List<MenuModel>>()

}