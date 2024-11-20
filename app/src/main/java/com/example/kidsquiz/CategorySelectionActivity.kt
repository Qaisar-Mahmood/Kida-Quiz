package com.example.kidsquiz

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CategorySelectionActivity : AppCompatActivity() {

    private var categorySound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_selection)

        categorySound = MediaPlayer.create(this, R.raw.category_sound)
        categorySound?.isLooping = true
        categorySound?.start()

        val btnAnimals = findViewById<Button>(R.id.animalsPlayButton)
        val btnBirds = findViewById<Button>(R.id.birdsPlayButton)
        val btnVegetables = findViewById<Button>(R.id.vegetablesPlayButton)
        val btnFruits = findViewById<Button>(R.id.fruitsPlayButton)

        btnAnimals.setOnClickListener {
            startQuiz("animals")
        }

        btnBirds.setOnClickListener {
            startQuiz("birds")
        }

        btnVegetables.setOnClickListener {
            startQuiz("vegetables")
        }

        btnFruits.setOnClickListener {
            startQuiz("fruits")
        }
    }

    private fun startQuiz(category: String) {
        categorySound?.stop()
        val intent = Intent(this, QuizActivity::class.java)
        intent.putExtra("category", category)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        categorySound?.release()
    }
}
