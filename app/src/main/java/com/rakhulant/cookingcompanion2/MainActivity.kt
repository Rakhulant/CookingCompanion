package com.rakhulant.cookingcompanion2

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_shopping_list.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.add(R.id.frame, RecipieFragment.newInstance())
            transaction.commit()
        }
        bottomBar.onItemSelected = {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            when(it){
                0 -> transaction.replace(R.id.frame, RecipieFragment.newInstance()).commit()
                1 -> transaction.replace(R.id.frame, ShoppingList.newInstance()).commit()
                2 -> transaction.replace(R.id.frame, ProfileFragment.newInstance()).commit()
            }

        }
    }

}