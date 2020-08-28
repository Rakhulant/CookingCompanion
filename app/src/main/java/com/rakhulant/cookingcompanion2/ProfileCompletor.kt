package com.rakhulant.cookingcompanion2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile_completor.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.*
import java.lang.NumberFormatException
import java.lang.StringBuilder

class ProfileCompletor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_completor)
        backBtn.setOnClickListener { finish() }
        saveBtn.setOnClickListener {
            val nameU = nameUser.text.toString()
            val phoneU = phoneNo.text.toString()
            var fos: FileOutputStream
            if (nameU.isNotEmpty() && phoneU.length == 10){       //trying to store name in internal storage
                try {
                    fos = openFileOutput("username.txt", Context.MODE_PRIVATE)
                    fos.write(nameU.toByteArray())
                    fos = openFileOutput("phoneno.txt",Context.MODE_PRIVATE)
                    fos.write(phoneU.toByteArray())
                }catch (e: FileNotFoundException){
                    e.printStackTrace()
                }catch (e: NumberFormatException){
                    e.printStackTrace()
                }catch (e: IOException){
                    e.printStackTrace()
                }catch (e: Exception){
                    e.printStackTrace()
                }
            finish() }}//closing activity and returning to MainActivity
    }
}