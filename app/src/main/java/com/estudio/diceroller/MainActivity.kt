package com.estudio.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var btnRoll: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitUI()
        InitListeners()
    }

    private fun InitUI() {
        btnRoll = findViewById(R.id.btnRoll)
        tvResult = findViewById(R.id.tvResult)
    }

    private fun InitListeners() {
        btnRoll.setOnClickListener {

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            val firstDice = Dice(6)
            tvResult.text = firstDice.roll().toString()
        }
    }

    private class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}