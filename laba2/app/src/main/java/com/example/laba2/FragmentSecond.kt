package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*

class FragmentSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // визначення макета для фрагмента
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    fun setText(result: String){
            resultText.text = "${result}"
    }
}