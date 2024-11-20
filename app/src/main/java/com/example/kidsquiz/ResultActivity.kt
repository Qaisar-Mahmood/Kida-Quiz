package com.example.kidsquiz

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private var resultSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        resultSound = MediaPlayer.create(this, R.raw.result_sound)
        resultSound?.isLooping = true
        resultSound?.start()

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnPlayAgain = findViewById<Button>(R.id.btnPlayAgain)

        val score = intent.getIntExtra("score", 0)
        val totalQuestions = intent.getIntExtra("totalQuestions", 0)

        tvResult.text = "$score/$totalQuestions"

        btnPlayAgain.setOnClickListener {
            resultSound?.stop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        resultSound?.release()
    }
}
