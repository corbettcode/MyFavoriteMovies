package com.corbettcode.myfavoritemovies

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyFavoriteMovies",
    ) {
        App(isLargeScreen = true)
    }
}