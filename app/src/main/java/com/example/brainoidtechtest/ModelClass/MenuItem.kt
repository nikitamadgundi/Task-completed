package com.example.brainoidtechtest.ModelClass

import java.io.Serializable

data class MenuItem(
    val title: String,
    val image: String,
    val image_caption: String
):Serializable

data class MenuResponse(
    val status: Int,
    val message: String,
    val menu: List<MenuItem>
):Serializable
