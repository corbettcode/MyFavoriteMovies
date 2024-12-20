package com.corbettcode.myfavoritemovies.ui.ext

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.corbettcode.myfavoritemovies.ui.common.CurrentPlatformTarget
import com.corbettcode.myfavoritemovies.ui.common.PlatformTarget
import io.github.aakira.napier.Napier


@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }


@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1


@Composable
fun Modifier.mouseClickVerticalScroll(listState: LazyListState): Modifier {
    return this
    return if (CurrentPlatformTarget == PlatformTarget.Jvm || CurrentPlatformTarget == PlatformTarget.Web) {
        var offset by remember { mutableStateOf(0f) }
        LaunchedEffect(offset) {
            Napier.i("atStart isScrolledToTheEnd ${listState.isScrolledToTheEnd()}")
            listState.scrollBy(-(offset * 1.5f))

        }

        return pointerInput(Unit) {
            detectVerticalDragGestures { change, dragAmount ->
                offset = dragAmount
            }
        }
    } else {
        this
    }
}

@Composable
fun Modifier.mouseClickHorizontalScroll(state: LazyListState): Modifier {
    return this
    return if (CurrentPlatformTarget == PlatformTarget.Jvm || CurrentPlatformTarget == PlatformTarget.Web) {
        var offset by remember { mutableStateOf(0f) }
        LaunchedEffect(offset) {
            state.scrollBy(-(offset * 1f))
        }

        return pointerInput(Unit) {
            detectHorizontalDragGestures { change, dragAmount ->
                offset = dragAmount
            }
        }
    } else {
        this
    }
}


