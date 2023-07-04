package com.example.brainoidtechtest.ModelClass

import java.io.Serializable


data class BookApiResponse(
val status: Int,
val message: String,
val books: List<Book>
):Serializable

data class Book(
    val id: Int,
    val book_name: String,
    val book_image: String,
    val subtitle: String,
    val full_book_image: String
):Serializable

