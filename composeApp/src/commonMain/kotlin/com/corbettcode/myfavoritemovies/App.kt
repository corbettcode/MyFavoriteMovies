package com.corbettcode.myfavoritemovies

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import com.corbettcode.myfavoritemovies.di.AppModule
import com.corbettcode.myfavoritemovies.theme.AppTheme
import com.corbettcode.myfavoritemovies.theme.LocalWindowSizeWidth
import com.corbettcode.myfavoritemovies.theme.WindowSize
import com.corbettcode.myfavoritemovies.ui.main.MainScreen
import com.corbettcode.myfavoritemovies.ui.splash.SplashScreen
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.ui.tooling.preview.Preview

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

/**
 * Get a resource from <sourceSet>/resources (for example, from commonMain/resources).
 */
@ExperimentalResourceApi
expect fun resource(path: String): Resource

@OptIn(ExperimentalResourceApi::class)
internal suspend fun loadResource(resourcePath: String): ByteArray {
    return resource(resourcePath).readBytes()
}

internal suspend fun loadFontResource(font: String) = loadResource("font/$font")
@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun loadDrawableResource(drawable: String) = org.jetbrains.compose.resources.painterResource(
    "drawable/$drawable"
)

val subTitleTextStyle: TextStyle
    @Composable get() = when (LocalWindowSizeWidth.current) {
        WindowSize.Expanded -> MaterialTheme.typography.headlineMedium
        WindowSize.Medium -> MaterialTheme.typography.titleMedium
        else -> // WindowWidthSizeClass.Compact
            MaterialTheme.typography.bodyMedium
    }
