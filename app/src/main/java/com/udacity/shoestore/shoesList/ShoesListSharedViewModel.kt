package com.udacity.shoestore.shoesList


import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesListSharedViewModel: ViewModel() {


    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
    get() = _name

    private val _size = MutableLiveData<String>()
    val size: LiveData<String>
    get() = _size

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
    get() = _company

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
    get() = _description


    fun addNewShoeToWarehouse(newName: String, newSize: String, newCompany: String, newDescription: String){
        _name.value = newName
        _size.value = newSize
        _company.value = newCompany
        _description.value = newDescription

    }






}