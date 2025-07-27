package io.skobinsky.septwedding.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import io.skobinsky.septwedding.util.LocalWindowSize
import io.skobinsky.septwedding.util.WindowSize
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.times

fun Modifier.actiniaFont(): Modifier {
    return this.fontFamily("Actinia")
}

@Composable
fun Modifier.actinia(
    fontSize: CSSLengthOrPercentageNumericValue = 4.cssRem,
    lineHeight: CSSLengthOrPercentageNumericValue = 2.5.cssRem
): Modifier {
    val windowSize = LocalWindowSize.current
    return this
        .actiniaFont()
        .textAlign(TextAlign.Center)
        .fontSize(fontSize * windowSize.getFontRatio())
        .lineHeight(lineHeight * windowSize.getFontRatio())
}

@Stable
private fun WindowSize.getFontRatio(): Float {
    return when {
        width > 1440 -> 1f
        width > 1200 -> 0.8f
        width > 800 -> 0.6f
        else -> 0.5f
    }
}