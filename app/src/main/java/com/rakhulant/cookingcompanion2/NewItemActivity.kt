package com.rakhulant.cookingcompanion2

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.rakhulant.cookingcompanion2.data.Item
import com.rakhulant.cookingcompanion2.data.ItemViewModel
import kotlinx.android.synthetic.main.activity_new_item.*
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.NumberFormatException

class NewItemActivity : AppCompatActivity() {

    private lateinit var mItemViewModel: ItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_item)
        backBtn.setOnClickListener{
            finish()
        }
        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        addBtn.setOnClickListener{
            insertDataToDatabase()
        }
    }
    private fun insertDataToDatabase(){
        val item = itemNameETV.text.toString()
        val qty = qtyETV.text.toString()
        if (item.isNotEmpty() && qty.isNotEmpty()){
            val item = Item(0, item, qty, false)
            mItemViewModel.addItem(item)
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            finish()
        }
        else if (item.isNotEmpty() && qty.isEmpty()){
            Toast.makeText(this, "Give Quantity please", Toast.LENGTH_SHORT).show()
        }
        else if(item.isEmpty() && qty.isNotEmpty()){
            Toast.makeText(this, "Give Item Name please", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Try Again", Toast.LENGTH_SHORT).show()
        }
    }
}