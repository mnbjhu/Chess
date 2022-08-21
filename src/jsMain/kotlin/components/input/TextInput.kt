package components.input

import csstype.*
import react.FC
import react.Props
import emotion.react.css
import react.dom.html.InputType
import react.dom.html.ReactHTML.input
import util.Constants.Colors

external interface TextInputProps : Props {
    var type: InputType
    var onChange: (String) -> Unit
    var placeholder: String
}

val TextInput = FC<TextInputProps> {
    input {
        css {
            all = Globals.unset
            border = Border(1.px, LineStyle.solid, Color(Colors.LIGHTGREY.toString()))
            borderRadius = 4.px
            width = 100.pct
            height = 100.pct
            paddingLeft = 16.px
            paddingTop = 2.px
            paddingBottom = 2.px
        }
        type = it.type
        onChange = { e -> it.onChange(e.target.value) }
        placeholder = it.placeholder
    }
}