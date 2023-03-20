package com.example.mad_105_user_input

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val ten = 0.010
    val fifteen = 0.015
    val twenty = 0.020
    val twentyFive = 0.025

    var mealCostInput: Double = 0.00
    var tipChoice: Int = 0
    var tipPercent: Double = 0.00


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealTotal: EditText = findViewById(R.id.txtMealTotal)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.buttonTipCalc)
        val result: TextView = findViewById(R.id.txtResult)


        charges.setOnClickListener {
            mealCostInput = mealTotal.text.toString().toDouble()
            val currency = DecimalFormat("$###,###.00")

            tipChoice = group.selectedItemPosition

            tipPercent = when (tipChoice){
                0 -> ten
                1 -> fifteen
                2 -> twenty
                3 -> twentyFive
                else -> fifteen
            }

            var total = mealCostInput * tipPercent
            var totalWithTip: Double = total + mealCostInput
            println(totalWithTip)

            result.text = "Tip = ${currency.format(total)}\nTotal With tip = ${currency.format(totalWithTip)} "

        }


    }
}