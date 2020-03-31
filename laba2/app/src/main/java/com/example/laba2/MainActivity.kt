package com.example.laba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    override fun onFragmentInteraction(result: String) {
        var fragment = supportFragmentManager.findFragmentById(R.id.FragmentSecond) as FragmentSecond
        if(fragment.isInLayout){
            fragment.setText(result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}