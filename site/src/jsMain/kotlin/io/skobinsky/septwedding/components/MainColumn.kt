package io.skobinsky.septwedding.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.functions.calc
import com.varabyte.kobweb.compose.css.functions.min
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import io.skobinsky.septwedding.util.ColumnMaxWidth
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
inline fun MainColumn(
    crossinline content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .width(calc { min(ColumnMaxWidth, 100.percent) })
            .padding(left = 24.px, right = 24.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}