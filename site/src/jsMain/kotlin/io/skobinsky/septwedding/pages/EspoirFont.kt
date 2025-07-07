package io.skobinsky.septwedding.pages

import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import org.jetbrains.compose.web.css.cssRem

fun Modifier.actiniaFont(): Modifier {
    return this.fontFamily("Actinia")
}

fun Modifier.actinia(
    fontSize: CSSLengthOrPercentageNumericValue = 4.cssRem,
    lineHeight: CSSLengthOrPercentageNumericValue = 2.5.cssRem
) = this
    .actiniaFont()
    .textAlign(TextAlign.Center)
    .fontSize(fontSize)
    .lineHeight(lineHeight)