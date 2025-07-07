package io.skobinsky.septwedding.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import io.skobinsky.septwedding.components.layouts.PageLayoutData
import io.skobinsky.septwedding.theme.AppColors
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

// A demo grid that appears on the homepage because it looks good
val HomeGridStyle = CssStyle.base {
    Modifier
        .gap(0.5.cssRem)
        .width(70.cssRem)
        .height(18.cssRem)
}

private val GridCellColorVar by StyleVariable<Color>()
val HomeGridCellStyle = CssStyle.base {
    Modifier
        .backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value())
        .borderRadius(1.cssRem)
}


@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Composable
inline fun MainColumn(
    crossinline content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.maxWidth(1500.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainColumn {
            SpanText(
                text = "Мы рады пригласить вас",
                modifier = Modifier
                    .margin(top = 24.px)
                    .actinia(2.cssRem)
            )
            SpanText(
                text = "на торжество, посвящённое",
                modifier = Modifier
                    .actinia(2.cssRem)
            )
            SpanText(
                text = "нашему бракосочетанию!",
                modifier = Modifier
                    .actinia(2.cssRem)
            )
        }
        Image(
            src = "/us_main.jpg",
            description = "Глеб и Ольга",
            modifier = Modifier
                .margin(top = 24.px)
                .fillMaxWidth()
                .maxHeight(500.px)
                .objectFit(ObjectFit.Cover)
                .display(DisplayStyle.Block)
        )
        MainColumn {
            SpanText(
                text = "20/09/2025",
                modifier = Modifier
                    .margin(top = 36.px)
                    .actinia(4.cssRem, 4.cssRem)
            )
            SpanText(
                text = "ОЛЬГА И ГЛЕБ",
                modifier = Modifier
                    .margin(top = 12.px)
                    .actinia(4.cssRem, 4.cssRem)
            )

            Row(
                modifier = Modifier.margin(top = 24.px),
                horizontalArrangement = Arrangement.spacedBy(16.px)
            ) {
                for (color in AppColors.BrandColors) {
                    Box(
                        Modifier
                            .size(64.px)
                            .borderRadius(50.percent)
                            .backgroundColor(color)
                    )
                }
            }
        }
    }
}
