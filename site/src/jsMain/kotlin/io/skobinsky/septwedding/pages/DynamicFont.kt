package io.skobinsky.septwedding.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import io.skobinsky.septwedding.theme.AppColors
import io.skobinsky.septwedding.util.LocalWindowSize
import io.skobinsky.septwedding.util.WindowSize
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.times

object FontFamilies {
    const val ACTINIA = "Actinia"
    const val BASKERVILLE = "Baskerville"
    const val BERLINERINS = "Berlinerins"
}

@Composable
fun Modifier.dynamicFont(
    fontSize: CSSLengthOrPercentageNumericValue = 4.cssRem,
    lineHeight: CSSLengthOrPercentageNumericValue = 2.5.cssRem,
    textAlign: TextAlign = TextAlign.Center,
    fontFamily: String = FontFamilies.BASKERVILLE,
    color: CSSColorValue = AppColors.BrandBlack,
): Modifier {
    val windowSize = LocalWindowSize.current
    return this
        .color(color)
        .fontFamily(fontFamily)
        .textAlign(textAlign)
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