package com.example.kidsquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val animalsQuestions = listOf(
        Question(
            imageResId = R.drawable.camel,
            options = listOf("Camel", "Tiger", "Elephant", "Giraffe"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.cat,
            options = listOf("Deer", "Cat", "Dog", "Horse"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.elephant,
            options = listOf("Goat", "Elephant", "Horse", "Tiger"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.fox,
            options = listOf("Dog", "Frog", "Monkey", "Fox"),
            correctAnswer = 3
        ),
        Question(
            imageResId = R.drawable.goat,
            options = listOf("Dog", "Goat", "Cat", "Deer"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.kangaroo,
            options = listOf("Deer", "Camel", "Kangaroo", "Fox"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.lion,
            options = listOf("Lion", "Goat", "Dog", "Sheep"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.monkey,
            options = listOf("Cat", "Camel", "Monkey", "Elephant"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.panda,
            options = listOf("Deer", "Panda", "Donkey", "Dog"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.zebra,
            options = listOf("Frog", "Camel", "Wolf", "Zebra"),
            correctAnswer = 3
        )
    )

    private val birdsQuestions = listOf(
        Question(
            imageResId = R.drawable.crow,
            options = listOf("Parrot", "Eagle", "Crow", "Owl"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.duck,
            options = listOf("Duck", "Falcon", "Owl", "Hawk"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.eagle,
            options = listOf("Crow", "Duck", "Peacock", "Eagle"),
            correctAnswer = 3
        ),
        Question(
            imageResId = R.drawable.hawk,
            options = listOf("Parrot", "Hawk", "Pigeon", "Sparrow"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.owl,
            options = listOf("Owl", "Parrot", "Peacock", "Duck"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.parrot,
            options = listOf("Hawk", "Sparrow", "Parrot", "Eagle"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.peacock,
            options = listOf("Peacock", "Eagle", "Crow", "Falcon"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.pigeon,
            options = listOf("Duck", "Pigeon", "Vulture", "Sparrow"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.sparrow,
            options = listOf("Hawk", "Peacock", "sparrow", "Owl"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.vulture,
            options = listOf("Vulture", "Pigeon", "Hawk", "Duck"),
            correctAnswer = 0
        )
    )

    private val fruitsQuestions = listOf(
        Question(
            imageResId = R.drawable.apple,
            options = listOf("Mango", "Cherry", "Apple", "Orange"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.banana,
            options = listOf("Cherry", "Banana", "Grape", "Watermelon"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.cherry,
            options = listOf("Orange", "Mango", "Pineapple", "Cherry"),
            correctAnswer = 3
        ),
        Question(
            imageResId = R.drawable.grape,
            options = listOf("Grape", "Strawberry", "Banana", "Mango"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.mango,
            options = listOf("Orange", "Mango", "Pineapple", "Watermelon"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.orange,
            options = listOf("Orange", "Cherry", "Apple", "Pomegranate"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.pineapple,
            options = listOf("Banana", "Orange", "Pineapple", "Watermelon"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.pomegranate,
            options = listOf("Pomegranate", "Grape", "Mango", "Apple"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.strawberry,
            options = listOf("Orange", "Strawberry", "Pomegranate", "Banana"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.watermelon,
            options = listOf("Strawberry", "Pineapple", "Watermelon", "Orange"),
            correctAnswer = 2
        )
    )

    private val vegetablesQuestions = listOf(
        Question(
            imageResId = R.drawable.broccoli,
            options = listOf("Tomato", "Cauliflower", "Onion", "Broccoli"),
            correctAnswer = 3
        ),
        Question(
            imageResId = R.drawable.cabbage,
            options = listOf("Potato", "Cabbage", "Carrot", "Cucumber"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.carrot,
            options = listOf("Carrot", "Onion", "Tomato", "Spinach"),
            correctAnswer = 0
        ),
        Question(
            imageResId = R.drawable.cauliflower,
            options = listOf("Potato", "Cauliflower", "Pepper", "Garlic"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.onion,
            options = listOf("Pumpkin", "Cabbage", "Tomato", "Onion"),
            correctAnswer = 3
        ),
        Question(
            imageResId = R.drawable.pepper,
            options = listOf("Cauliflower", "Pepper", "Garlic", "Carrot"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.potatoe,
            options = listOf("Pumpkin", "Carrot", "Potato", "Cucumber"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.pumpkin,
            options = listOf("Tomato", "Pumpkin", "Spinach", "Broccoli"),
            correctAnswer = 1
        ),
        Question(
            imageResId = R.drawable.spinach,
            options = listOf("Potato", "Onion", "Spinach", "Cabbage"),
            correctAnswer = 2
        ),
        Question(
            imageResId = R.drawable.tomato,
            options = listOf("Pepper", "Tomato", "Pumpkin", "Spinach"),
            correctAnswer = 1
        )
    )

    fun getQuestions(category: String): List<Question> {
        return when (category) {
            "animals" -> animalsQuestions
            "birds" -> birdsQuestions
            "fruits" -> fruitsQuestions
            "vegetables" -> vegetablesQuestions
            else -> emptyList()
        }
    }
}