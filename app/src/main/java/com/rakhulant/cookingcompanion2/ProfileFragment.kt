package com.rakhulant.cookingcompanion2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.*
import java.lang.StringBuilder


class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editBtn.setOnClickListener {
            startActivity(Intent(context, ProfileCompletor::class.java))
        }
        fetch()
    }
    private fun fetch(){
        try {
            val bR1 = BufferedReader(InputStreamReader(context?.openFileInput("phoneno.txt")))
            val stringBuilder: StringBuilder = StringBuilder()                                     //for phone no
            var text: String? = null
            while ({text = bR1.readLine(); text}() != null){
                stringBuilder.append(text)
            }
            val phone = stringBuilder.toString()
            if(phone.isNotEmpty()){
                noPhone.text = "+91 $phone"
            }
            stringBuilder.clear()
            val bR = BufferedReader(InputStreamReader(context?.openFileInput("username.txt")))
            var text1: String? = null
            while ({text1 = bR.readLine(); text1}() != null){
                stringBuilder.append(text1)
            }
            val name = stringBuilder.toString()
            if(name.isNotEmpty()){
                username.text = name.toString()
            }
        }catch (e: FileNotFoundException){
            e.printStackTrace()
        }catch (e: Exception){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        fetch()
    }
}