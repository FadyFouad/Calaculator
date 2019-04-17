package com.etatech.calaculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var oper1: Double? = null
    private var oper2: Double = 0.0
    private var pendingOper: String = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result: EditText = findViewById(R.id.numET)
        val newResult: EditText = findViewById(R.id.newTextET)
        val viewResults by lazy { findViewById<TextView>(R.id.resultsTV) }
        //TODO INIT BUTTONS
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

        val listner = View.OnClickListener { v ->
            val b = v as Button
            newResult.append(b.text)
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

    }
}
