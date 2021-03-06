package com.rakhulant.cookingcompanion2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application){
    val reaAllData: LiveData<List<Item>>
    private val repository: ItemRepository
    init {
        val itemDao = ItemDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        reaAllData = repository.readAllData
    }
    fun addItem(item: Item){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(item)
        }
    }
}