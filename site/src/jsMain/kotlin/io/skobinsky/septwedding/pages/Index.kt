package io.skobinsky.septwedding.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.calc
import com.varabyte.kobweb.compose.css.functions.min
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import io.skobinsky.septwedding.components.MainColumn
import io.skobinsky.septwedding.components.TableColumn
import io.skobinsky.septwedding.components.TableRow
import io.skobinsky.septwedding.components.layouts.PageLayoutData
import io.skobinsky.septwedding.icons.CakeIcon
import io.skobinsky.septwedding.icons.Dinner
import io.skobinsky.septwedding.icons.FinishIcon
import io.skobinsky.septwedding.icons.GuestsGathering
import io.skobinsky.septwedding.icons.StartBranch
import io.skobinsky.septwedding.theme.AppColors
import io.skobinsky.septwedding.util.COLUMN_MAX_WIDTH
import io.skobinsky.septwedding.util.ColumnMaxWidth
import io.skobinsky.septwedding.util.LocalWindowSize
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Br
import kotlin.math.min

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

private const val TelegramLink = "https://t.me/+chyjjdkxppg3Yzcy"
private const val NeZaGoramiLink = "https://yandex.ru/maps/-/CHTt5RM5"

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
                    .margin(top = 36.px)
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                    )
            )
            SpanText(
                text = "на торжество, посвящённое",
                modifier = Modifier
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                    )
            )
            SpanText(
                text = "нашему бракосочетанию!",
                modifier = Modifier
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                    )
            )
        }
        BlockImage(
            src = "/us_main.jpg",
            description = "Глеб и Ольга",
            modifier = Modifier.margin(top = 36.px)
        )
        MainColumn {
            SpanText(
                text = "20/09/2025",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )
            SpanText(
                text = "ОЛЬГА И ГЛЕБ",
                modifier = Modifier
                    .margin(top = 12.px, bottom = 48.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )
        }
        BlockImage(
            src = "/restaurant_cover.jpg",
            description = "Место торжества"
        )
        MainColumn {
            SpanText(
                text = "Дорогие гости!",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(
                        fontSize = 8.cssRem,
                        lineHeight = 8.cssRem,
                        fontFamily = FontFamilies.BERLINERINS
                    )
            )
            Br()
            SpanText(
                text = "Мы будем счастливы разделить с Вами радость неповторимого для нас дня - дня нашей свадьбы!",
                modifier = Modifier
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
            Br()
            SpanText(
                text = "Приглашаем присоединиться к нашему празднику и украсить его своим присутствием!",
                modifier = Modifier
                    .margin(top = 12.px)
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
        }
        RightLeafs(Modifier.align(Alignment.End))
        MainColumn {
            SpanText(
                text = "ПРОГРАММА ДНЯ",
                modifier = Modifier
                    .margin(bottom = 12.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )

            TableColumn {
                TableRow(
                    leadingContent = {
                        StartBranch()
                    }
                )
                TimelineRow(36.px)
                TableRow(
                    leadingContent = {
                        GuestsGathering()
                    },
                    title = "17:00",
                    subtitle = "Сбор гостей"
                )
                TimelineRow()
                TableRow(
                    leadingContent = {
                        Dinner()
                    },
                    title = "17:30",
                    subtitle = "Банкет"
                )
                TimelineRow()
                TableRow(
                    leadingContent = {
                        CakeIcon()
                    },
                    title = "20:00",
                    subtitle = "Торт"
                )
                TimelineRow()
                TableRow(
                    leadingContent = {
                        FinishIcon()
                    },
                    title = "23:00",
                    subtitle = "Завершение торжества"
                )
                TimelineRow(36.px)
                TableRow(
                    leadingContent = {
                        StartBranch(Modifier.rotate(180.deg))
                    }
                )
            }

            SpanText(
                text = "ДРЕСС-КОД",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )
            SpanText(
                text = "Мы будем признательны, если Вы поддержите",
                modifier = Modifier
                    .margin(top = 24.px)
                    .dynamicFont(
                        fontSize = 2.5.cssRem,
                        lineHeight = 3.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
            SpanText(
                text = "цветовую гамму нашей свадьбы.",
                modifier = Modifier
                    .dynamicFont(
                        fontSize = 2.5.cssRem,
                        lineHeight = 3.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
            Row(
                modifier = Modifier
                    .margin(top = 12.px, bottom = 12.px)
                    .display(DisplayStyle.Flex)
                    .flexWrap(FlexWrap.Wrap),
                horizontalArrangement = Arrangement.Center
            ) {
                for (color in AppColors.BrandColors) {
                    Box(
                        Modifier
                            .margin(
                                top = 12.px,
                                bottom = 12.px,
                                left = 8.px,
                                right = 8.px
                            )
                            .size(64.px)
                            .borderRadius(50.percent)
                            .backgroundColor(color)
                    )
                }
            }
            SpanText(
                text = "СЛОВО-ТАБУ",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )
            SpanText(
                text = "Убедительно просим не использовать слово «Горько» на протяжении всей свадьбы.",
                modifier = Modifier
                    .margin(top = 24.px)
                    .dynamicFont(
                        fontSize = 2.5.cssRem,
                        lineHeight = 3.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
            SpanText(
                text = "Спасибо за понимание",
                modifier = Modifier
                    .margin(top = 24.px)
                    .dynamicFont(
                        fontSize = 4.cssRem,
                        fontFamily = FontFamilies.BERLINERINS
                    )
            )
            SpanText(
                text = "МЕСТО ПРОВЕДЕНИЯ",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(4.cssRem, 4.cssRem)
            )
            SpanText(
                text = "Наша свадьба будет проходить в ресторане «NEзаGORAMI» по адресу Марксистская улица, 7",
                modifier = Modifier
                    .margin(top = 24.px)
                    .dynamicFont(
                        fontSize = 2.5.cssRem,
                        lineHeight = 3.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
        }
        BlockImage(
            src = "/nezagorami.jpg.webp",
            description = "Место проведения",
            modifier = Modifier.margin(top = 36.px)
        )
        MainColumn {
            Box(
                Modifier
                    .margin(top = 36.px, bottom = 36.px)
                    .onClick {
                        window.open(
                            url = NeZaGoramiLink,
                            target = "_blank"
                        )
                    }
                    .cursor(Cursor.Pointer)
                    .backgroundColor(AppColors.BrandGreen)
                    .fillMaxWidth()
                    .height(64.px),
                contentAlignment = Alignment.Center
            ) {
                SpanText(
                    text = "ПОСМОТРЕТЬ НА КАРТЕ",
                    modifier = Modifier
                        .dynamicFont(
                            fontSize = 3.cssRem,
                            lineHeight = 3.5.cssRem,
                            fontFamily = FontFamilies.BASKERVILLE,
                            color = AppColors.BrandGreenDark
                        )
                )
            }
        }
        Box {
            val currentWinWidth = LocalWindowSize.current.width
            val leftMargin = calculateLeft(currentWinWidth)
            Column {
                SpanText(
                    text = "Пожалуйста, подтвердите свое присутствие, вступив ",
                    modifier = Modifier
                        .margin(
                            top = 24.px,
                            left = leftMargin,
                            right = 24.px
                        )
                        .fillMaxWidth(35.percent)
                        .dynamicFont(
                            fontSize = 3.cssRem,
                            lineHeight = 3.5.cssRem,
                            fontFamily = FontFamilies.BASKERVILLE,
                            textAlign = TextAlign.Start
                        )
                )
                Link(
                    path = TelegramLink,
                    modifier = Modifier
                        .margin(
                            left = leftMargin,
                            right = 24.px
                        )
                        .fillMaxWidth(35.percent)
                        .dynamicFont(
                            fontSize = 3.cssRem,
                            lineHeight = 3.5.cssRem,
                            fontFamily = FontFamilies.BASKERVILLE,
                            textAlign = TextAlign.Start
                        ),
                    text = "в наш чат Telegram."
                )
            }
            RightLeafs(Modifier.align(Alignment.CenterEnd))
        }
        MainColumn {
            SpanText(
                text = "Мы ждем встречи с вами на нашей свадьбе!",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(
                        fontSize = 3.cssRem,
                        lineHeight = 3.5.cssRem,
                        fontFamily = FontFamilies.BASKERVILLE
                    )
            )
            SpanText(
                text = "С любовью,",
                modifier = Modifier
                    .margin(top = 48.px)
                    .dynamicFont(
                        fontSize = 5.cssRem,
                        lineHeight = 5.cssRem,
                        fontFamily = FontFamilies.BERLINERINS
                    )
            )
            SpanText(
                text = "Глеб и Ольга",
                modifier = Modifier
                    .margin(bottom = 48.px)
                    .dynamicFont(
                        fontSize = 8.cssRem,
                        lineHeight = 8.cssRem,
                        fontFamily = FontFamilies.BERLINERINS
                    )
            )
        }
    }
}

private fun calculateLeft(currentWinWidth: Int): CSSSizeValue<CSSUnit.px> {
    val colWidth = min(
        currentWinWidth,
        COLUMN_MAX_WIDTH
    )
    val remaining = (currentWinWidth - colWidth) / 2
    val addable = if (colWidth < currentWinWidth) {
        0
    } else {
        24
    }
    return (remaining + addable).px
}

@Composable
private fun RightLeafs(
    modifier: Modifier = Modifier
) {
    Image(
        src = "/plant_leafs.png",
        description = "",
        modifier = modifier
            .fillMaxWidth(50.percent)
            .objectFit(ObjectFit.Cover)
            .display(DisplayStyle.Block)
    )
}


@Composable
private fun BlockImage(
    src: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Image(
        src = src,
        description = description,
        modifier = modifier
            .width(calc { min(100.percent, ColumnMaxWidth) })
            .maxHeight(700.px)
            .objectFit(ObjectFit.Cover)
            .display(DisplayStyle.Block)
    )
}

@Composable
private fun TimelineRow(
    height: CSSLengthOrPercentageNumericValue = 72.px,
) {
    TableRow(
        leadingContent = {
            Box(
                Modifier
                    .size(2.px, height = height)
                    .backgroundColor(AppColors.BrandBlack)
            )
        }
    )
}