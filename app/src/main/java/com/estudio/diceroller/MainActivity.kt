package com.estudio.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import javax.crypto.spec.IvParameterSpec


class MainActivity : AppCompatActivity() {

    lateinit var btnRoll: Button
    lateinit var ivDiceRoll: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitUI()
        InitListeners()
    }

    private fun InitUI() {
        btnRoll = findViewById(R.id.btnRoll)
        ivDiceRoll = findViewById(R.id.ivDiceRoll)
        ivDiceRoll.setImageResource(R.drawable.dice_1)
    }

    private fun InitListeners() {
        btnRoll.setOnClickListener {

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            val firstDice = Dice(6)
            val result: Int = firstDice.roll()

            printDice(result)
        }
    }

    private class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun printDice(roll: Int) {

        val drawableResourse = when (roll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }

        return ivDiceRoll.setImageResource(drawableResourse)
    }
}