package com.rakhulant.cookingcompanion2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val itemName:String,
    val qty: String,
    val status: Boolean
){
}