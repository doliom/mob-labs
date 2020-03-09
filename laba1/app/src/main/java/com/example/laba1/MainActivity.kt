package com.example.laba1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    lateinit var cb_lembic : CheckBox
    lateinit var cb_luminarc : CheckBox
    lateinit var cb_ceramic : CheckBox

    lateinit var cb_0 : CheckBox
    lateinit var  cb_500 : CheckBox
    lateinit var  cb_1000: CheckBox

    lateinit var sp_tableware : Spinner
    lateinit var btn_submit : Button
    lateinit var tv_result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cb_lembic = findViewById(R.id.check_lembik) as CheckBox
        cb_luminarc = findViewById(R.id.check_luminarc) as CheckBox
        cb_ceramic = findViewById(R.id.check_ceramic) as CheckBox

        cb_0 = findViewById(R.id.check_0) as CheckBox
        cb_500 = findViewById(R.id.check_500) as CheckBox
        cb_1000 = findViewById(R.id.check_1000) as CheckBox

        btn_submit = findViewById(R.id.ok) as Button
        tv_result = findViewById(R.id.result) as TextView
        sp_tableware = findViewById(R.id.check_tableware) as Spinner

        btn_submit.setOnClickListener(View.OnClickListener {
            var result = ""


            if (sp_tableware.selectedItem.toString().equals(R.array.tablewarelist) or((cb_lembic.isChecked == false) and (cb_luminarc.isChecked == false)
                and (cb_ceramic.isChecked == false)) or ((cb_0.isChecked == false) and (cb_500.isChecked == false)
                        and (cb_1000.isChecked == false))){
                result += "Ви не вибрали с кожного списку по параметру. Виберіть та повторіть спробу!"
            }
            else {
                result += "Вид посуду: ${sp_tableware?.selectedItem.toString()}\n"

                if (cb_lembic.isChecked) {
                    result += "Виробник: "
                    result += "Lembic\n "
                }
                if (cb_luminarc.isChecked) {
                    result += "Виробник: "
                    result += "Lumiranc\n "
                }
                if (cb_ceramic.isChecked) {
                    result += "Виробник: "
                    result += "Souful Cearmic\n"
                }

                if (cb_0.isChecked) {
                    result += "Діапазон цін: "
                    result += "0 - 500\n"
                }
                if (cb_500.isChecked) {
                    result += "Діапазон цін: "
                    result += "500 - 1000\n"
                }
                if (cb_1000.isChecked) {
                    result += "Діапазон цін: "
                    result += "1000 - ...\n"
                }
            }
            tv_result.text = result
        })

    }
}
