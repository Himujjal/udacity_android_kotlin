package io.grasp.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

// AppCompatActivity provides Activity features to MainActivity while
//  providing backwards compatibility for older android version
class MainActivity : AppCompatActivity() {

    // may be initialized later. Its non-nullable
    private lateinit var diceImage: ImageView
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        rollButton.text = "Let's Roll"

        rollButton.setOnClickListener {
            rollDice()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val randomInt: Int = Random().nextInt(6) + 1
        val drawableImage = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(drawableImage)
    }
}
