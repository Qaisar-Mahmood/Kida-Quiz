package com.example.kidsquiz

data class Question(
    val imageResId: Int,
    val options: List<String>,
    val correctAnswer: Int
)
