package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


                val rollButton: Button = findViewById(R.id.btnRoll)
                rollButton.setOnClickListener {
                    //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
                    //toast.show()

                    rollDice()
                }

            }

            private fun rollDice() {
                val dice = Dice(6)
                val diceRoll = dice.roll()
                val diceImage: ImageView = findViewById(R.id.imageView)

                when (diceRoll) {
                    1 -> diceImage.setImageResource(R.drawable.dice_1)
                    2 -> diceImage.setImageResource(R.drawable.dice_2)
                    3 -> diceImage.setImageResource(R.drawable.dice_3)
                    4 -> diceImage.setImageResource(R.drawable.dice_4)
                    5 -> diceImage.setImageResource(R.drawable.dice_5)
                    6 -> diceImage.setImageResource(R.drawable.dice_6)
                }


                val txtResultado: TextView = findViewById(R.id.txtResultado)
                val edtNumber: EditText = findViewById(R.id.luckynumber)
                val number: Int = edtNumber.text.toString().toInt()

                if( diceRoll == number){
                    txtResultado.setText("Você ganhou!")
                }else{
                    txtResultado.setText("Você perdeu!")
                }
            }
        }


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
