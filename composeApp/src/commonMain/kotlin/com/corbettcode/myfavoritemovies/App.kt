package com.corbettcode.myfavoritemovies

import androidx.compose.runtime.*
import com.corbettcode.myfavoritemovies.di.AppModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

import com.corbettcode.myfavoritemovies.theme.AppTheme

@Composable
@Preview
fun App() {
    MyApplication()
}

@Composable
internal fun MyApplication() = AppTheme {
    Napier.base(DebugAntilog())
    val viewModel by lazy {
        AppModule.homeViewModel
    }

    var splash: Boolean by remember { mutableStateOf(true) }
    if (splash) {
        SplashScreen {
            if (splash) {
                splash = false
            }
        }
    } else {
        MainScreen(viewModel)
    }


}
