package com.example.laba2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

interface OnFragmentInteractionListener {
    fun onFragmentInteraction(result: String)
}

class FragmentFirst : Fragment() {
    private var listener: OnFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun okClicked()
    {
        var result = ""
        ok.setOnClickListener{
            var result = ""

            if (spinner.selectedItem.toString().equals(R.array.tablewarelist) or((check_lembik.isChecked == false) and (check_luminarc.isChecked == false)
                        and (check_ceramic.isChecked == false)) or ((check_0.isChecked == false) and (check_500.isChecked == false)
                        and (check_1000.isChecked == false))){
                result += "Ви не вибрали с кожного списку по параметру. Виберіть та повторіть спробу!"
            }
            else {
                result += "Вид посуду: ${spinner?.selectedItem.toString()}\n"

                if (check_lembik.isChecked) {
                    result += "Виробник: "
                    result += "Lembic\n "
                }
                if (check_luminarc.isChecked) {
                    result += "Виробник: "
                    result += "Lumiranc\n "
                }
                if (check_ceramic.isChecked) {
                    result += "Виробник: "
                    result += "Souful Cearmic\n"
                }

                if (check_0.isChecked) {
                    result += "Діапазон цін: "
                    result += "0 - 500\n"
                }
                if (check_500.isChecked) {
                    result += "Діапазон цін: "
                    result += "500 - 1000\n"
                }
                if (check_1000.isChecked) {
                    result += "Діапазон цін: "
                    result += "1000 - ...\n"
                }
            }
                listener?.onFragmentInteraction(result)
            }
        }
    }

