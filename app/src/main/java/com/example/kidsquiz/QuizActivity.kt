package com.example.kidsquiz

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Vibrator
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private val quizViewModel: QuizViewModel by viewModels()
    private lateinit var questions: List<Question>
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var imageQuiz: ImageView
    private lateinit var option1: Button
    private lateinit var option2: Button
    private lateinit var option3: Button
    private lateinit var option4: Button
    private var correctSound: MediaPlayer? = null
    private var wrongSound: MediaPlayer? = null
    private var quizSound: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        imageQuiz = findViewById(R.id.imageQuiz)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)

        quizSound = MediaPlayer.create(this, R.raw.quiz_sound)
        quizSound?.isLooping = true
        quizSound?.start()

        val category = intent.getStringExtra("category") ?: "animals"
        questions = quizViewModel.getQuestions(category)

        loadQuestion()

        option1.setOnClickListener { checkAnswer(0) }
        option2.setOnClickListener { checkAnswer(1) }
        option3.setOnClickListener { checkAnswer(2) }
        option4.setOnClickListener { checkAnswer(3) }
    }

    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]
            imageQuiz.setImageResource(question.imageResId)

            option1.text = question.options[0]
            option2.text = question.options[1]
            option3.text = question.options[2]
            option4.text = question.options[3]

            resetOptions()
        } else {
            showResult()
        }
    }

    private fun checkAnswer(selectedOption: Int) {
        val currentQuestion = questions[currentQuestionIndex]
        resetOptions()

        if (selectedOption == currentQuestion.correctAnswer) {
            playSound(R.raw.correct_answer)
            getOptionButton(selectedOption).apply {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_tick, 0)
            }
            score++
        } else {
            playSound(R.raw.wrong_answer)
            vibrate()
            getOptionButton(selectedOption).apply {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_cross, 0)
            }
            getOptionButton(currentQuestion.correctAnswer).apply {
                setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_tick, 0)
            }
        }


        Handler(Looper.getMainLooper()).postDelayed({
            currentQuestionIndex++
            loadQuestion()
        }, 2000)
    }

    private fun showResult() {
        quizSound?.stop()
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("totalQuestions", questions.size)
        startActivity(intent)
        finish()
    }

    private fun playSound(soundResId: Int) {
        val sound = MediaPlayer.create(this, soundResId)
        sound.start()
        sound.setOnCompletionListener {
            sound.release()
        }
    }

    private fun vibrate() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(200)
    }

    private fun getOptionButton(index: Int): Button {
        return when (index) {
            0 -> option1
            1 -> option2
            2 -> option3
            3 -> option4
            else -> throw IllegalArgumentException("Invalid option index")
        }
    }

    private fun resetOptions() {
        val defaultDrawable = 0
        listOf(option1, option2, option3, option4).forEach {
            it.setCompoundDrawablesWithIntrinsicBounds(0, 0, defaultDrawable, 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        quizSound?.release()
        correctSound?.release()
        wrongSound?.release()
    }
}
