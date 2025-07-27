package io.skobinsky.septwedding.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.text.SpanText
import io.skobinsky.septwedding.pages.FontFamilies
import io.skobinsky.septwedding.pages.dynamicFont
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun TableRow(
    leadingContent: @Composable () -> Unit,
    title: String? = null,
    subtitle: String? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .margin(right = 24.px)
                .width(100.px),
            contentAlignment = Alignment.Center
        ) {
            leadingContent()
        }
        Column {
            title?.let {
                SpanText(
                    text = it,
                    modifier = Modifier
                        .dynamicFont(
                            fontSize = 2.5.cssRem,
                            lineHeight = 3.cssRem,
                            fontFamily = FontFamilies.BASKERVILLE
                        )
                )
            }
            subtitle?.let {
                SpanText(
                    text = it,
                    modifier = Modifier
                        .dynamicFont(
                            fontSize = 3.cssRem,
                            lineHeight = 3.5.cssRem,
                            fontFamily = FontFamilies.BASKERVILLE
                        )
                )
            }
        }
    }
}