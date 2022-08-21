package components.input

import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.ReactNode
import react.dom.html.ReactHTML.button
import util.Constants.Colors

external interface ButtonProps : Props {
    var children: ReactNode
    var onClick: () -> Unit
}

val Button = FC<ButtonProps> {
    button {
        css {
            all = Globals.unset
            width = 100.pct
            height = 100.pct
            padding = 4.px
            border = Border(1.px, LineStyle.solid, Color(Colors.LIGHTGREY.toString()))
            borderRadius = 4.px
            display = Display.flex
            alignItems = AlignItems.center
            justifyContent = JustifyContent.center
//            cursor = Cursor.pointer
        }
        onClick = { _ ->
            it.onClick()
        }
        +it.children
    }
}