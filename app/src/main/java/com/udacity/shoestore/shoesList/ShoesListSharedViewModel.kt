package com.udacity.shoestore.shoesList

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesListSharedViewModel: ViewModel(), Observable {
    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field){
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe)

        }
    }

    fun getNewShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addNewShoe(item: Shoe?){
        item?.let {
            shoes.value?.add(item)
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }


}