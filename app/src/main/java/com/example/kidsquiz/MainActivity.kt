package com.example.kidsquiz

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mainActivitySound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivitySound = MediaPlayer.create(this, R.raw.category_sound)
        mainActivitySound?.isLooping = true
        mainActivitySound?.start()

        val btnStartQuiz = findViewById<Button>(R.id.startQuizButton)

        btnStartQuiz.setOnClickListener {
            mainActivitySound?.stop()
            startActivity(Intent(this, CategorySelectionActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainActivitySound?.release()
    }
}
