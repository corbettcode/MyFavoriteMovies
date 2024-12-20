package com.corbettcode.myfavoritemovies.ui.components

import androidx.compose.runtime.Composable

@Composable
internal expect fun YoutubeDialogScreen(url: String, onClose: () -> Unit)