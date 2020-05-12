package com.example.lab3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import android.view.View
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        showResult()
    }

    fun showResult(){
        val filename = getString(R.string.filename)
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput(filename)

        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)

        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null

        while({text = bufferedReader.readLine(); text} () != null) {
            stringBuilder.append(text)
            stringBuilder.append("\n\n")
        }

        textresult.setText(stringBuilder.toString())

    }

    fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, duration).show()
    }
}
