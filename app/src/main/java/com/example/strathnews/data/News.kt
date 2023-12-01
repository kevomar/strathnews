package com.example.strathnews.data

import java.util.Date

data class News(
    val image: Int,
    val title: String,
    val description: String,
    val author: String,
    val date: Date,
    val content: String
)

