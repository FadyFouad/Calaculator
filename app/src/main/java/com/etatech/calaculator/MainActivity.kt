package com.etatech.calaculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var oper1: Double? = null
    private var oper2: Double = 0.0
    private var pendingOper: String = "="
    val viewOperation by lazy { findViewById<TextView>(R.id.operat) }
    private lateinit var inNum: EditText
    private lateinit var result: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.results)
        inNum = findViewById(R.id.newTextET)

        //TODO INIT BUTTONS Or Use kotlinx.android.synthetic.main.activity_main.
        val in0: Button = findViewById(R.id.num_zero)
        val in1: Button = findViewById(R.id.num_one)
        val in2: Button = findViewById(R.id.num_two)
        val in3: Button = findViewById(R.id.num_three)
        val in4: Button = findViewById(R.id.num_four)
        val in5: Button = findViewById(R.id.num_five)
        val in6: Button = findViewById(R.id.num_six)
        val in7: Button = findViewById(R.id.num_sev)
        val in8: Button = findViewById(R.id.num_eight)
        val in9: Button = findViewById(R.id.num_nine)

        val dot: Button = findViewById(R.id.num_dot)
        val mul: Button = findViewById(R.id.num_mult)
        val div: Button = findViewById(R.id.num_divide)
        val plus: Button = findViewById(R.id.num_add)
        val sub: Button = findViewById(R.id.num_sub)
        val equal: Button = findViewById(R.id.num_eq)

        val listner = View.OnClickListener { v ->
            val b = v as Button
            inNum.append(b.text)
        }

        in0.setOnClickListener(listner)
        in1.setOnClickListener(listner)
        in2.setOnClickListener(listner)
        in3.setOnClickListener(listner)
        in4.setOnClickListener(listner)
        in5.setOnClickListener(listner)
        in6.setOnClickListener(listner)
        in7.setOnClickListener(listner)
        in8.setOnClickListener(listner)
        in9.setOnClickListener(listner)
        dot.setOnClickListener(listner)


        val operationLis = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            val value = inNum.text.toString().toDouble()
            if (value!=null) {//TODO isNotEmpty()
                performOperation(value, op)
                Toast.makeText(this,"->$value",Toast.LENGTH_LONG).show()
            }
            pendingOper = op
            viewOperation.text = pendingOper
        }


        mul.setOnClickListener(operationLis)
        div.setOnClickListener(operationLis)
        plus.setOnClickListener(operationLis)
        sub.setOnClickListener(operationLis)
        equal.setOnClickListener(operationLis)
    }
    private fun performOperation(value: Double, operation: String) {
        if (oper1 == null) {
            oper1 = value.toDouble()
        } else {
            oper2 = value.toDouble()

            if (pendingOper == "=") {
                pendingOper = operation
            }

            when (pendingOper) {
                "=" -> oper1 = oper2
                "/" -> if (oper2 == 0.0) {
                    oper1 = Double.NaN   // handle attempt to divide by zero
                } else {
                    oper1 = oper1!! / oper2
                }
                "*" -> oper1 = oper1!! * oper2
                "-" -> oper1 = oper1!! - oper2
                "+" -> oper1 = oper1!! + oper2
            }
        }
        result.setText(oper1.toString())
        inNum.setText("")
    }
}
