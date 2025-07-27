package io.skobinsky.septwedding.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.browser.window

val LocalWindowSize = compositionLocalOf { WindowSize.getCurrent() }

@Stable
data class WindowSize(
    val width: Int,
    val height: Int,
) {
    companion object {
        fun getCurrent() = WindowSize(
            width = window.innerWidth,
            height = window.innerHeight
        )
    }
}

@Composable
fun getWindowSize(): State<WindowSize> {
    val windowSizeState = remember {
        mutableStateOf(
            WindowSize.getCurrent()
        )
    }
    DisposableEffect(Unit) {
        window.addEventListener(
            type = "resize",
            callback = {
                windowSizeState.value = WindowSize.getCurrent()
            }
        )
        onDispose {
            window.removeEventListener("resize", {})
        }
    }
    return windowSizeState
}