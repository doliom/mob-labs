package com.example.lab3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception
import java.time.Duration
import android.content.Intent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dishes = ""
        var producer = ""
        var cost = ""
        ok.setOnClickListener(View.OnClickListener {
            dishes = ""
            producer = ""
            cost = ""

            if (check_tableware.selectedItem.toString().equals(R.array.tablewarelist) or((check_lembik.isChecked == false) and (check_luminarc.isChecked == false)
                        and (check_ceramic.isChecked == false)) or ((check_0.isChecked == false) and (check_500.isChecked == false)
                        and (check_1000.isChecked == false))){
                showToast("Ви не вибрали с кожного списку по параметру. Виберіть та повторіть спробу!")
            }
            else {
                dishes += "Вид посуду: ${check_tableware?.selectedItem.toString()}"
                producer += "Виробник:  "
                if (check_lembik.isChecked) {
                    producer += "Lembic "
                }
                if (check_luminarc.isChecked) {
                    producer += "Lumiranc "
                }
                if (check_ceramic.isChecked) {
                    producer += "Souful Cearmic "
                }

                cost += "Діапазон цін:  "
                if (check_0.isChecked) {
                    cost += "0 - 500   "
                }
                if (check_500.isChecked) {
                    cost += "500 - 1000   "
                }
                if (check_1000.isChecked) {
                    cost += "1000 - ...  "
                }
                writeInFile(dishes, producer, cost)
            }
        })
        open_button.setOnClickListener(View.OnClickListener {
            if ((dishes != "") and (producer != "") and (cost != "")){
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
            else{
                showToast("Файл пустий")
            }
        })
    }

    fun writeInFile(dishes: String, producer: String, cost: String){
        val file = getString(R.string.filename)
        val fileOutputStream: FileOutputStream
        try{
            fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
            fileOutputStream.write(dishes.toByteArray())
            fileOutputStream.write(producer.toByteArray())
            fileOutputStream.write(cost.toByteArray())
        }
        catch (e: FileNotFoundException){
            e.printStackTrace()
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        showToast("Saved successful")
    }

    fun Context.showToast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, duration).show()
    }
}