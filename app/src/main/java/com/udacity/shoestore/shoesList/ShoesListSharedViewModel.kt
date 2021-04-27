package com.udacity.shoestore.shoesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListSharedViewModel: ViewModel() {


    var currentShoe: Shoe? = null


    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes


    private val _eventCloseScreen = MutableLiveData<Boolean>()
    val eventCloseScreen: LiveData<Boolean>
        get() = _eventCloseScreen


    fun createNewShoeObject(){
        currentShoe = Shoe("", "", "", "")
    }

    fun onEventCloseComplete() {
        _eventCloseScreen.value = false
    }

    fun saveItem(){
        val listShoes = mutableListOf<Shoe>()

        _shoes.value?.let {
            listShoes.addAll(it)
        }

        currentShoe?.let {
            listShoes.add(it)
        }

        _shoes.value = listShoes
        _eventCloseScreen.value = true
    }

    fun deleteItem(item: Shoe){
        _shoes.value?.remove(item)
    }

}