import csstype.px
import csstype.rgb
import react.FC
import react.Props
import emotion.react.css
import kotlinx.browser.window
import position.Parser
import position.Position
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useState

external interface WelcomeProps : Props {
    var name: String
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)

    div {
        css {
            padding = 5.px
        }
        +JSON.stringify(Parser.Companion.toPosition.fen(Position.Companion.INITIAL_POSITION));
    }
    input {
        css {
            marginTop = 5.px
            marginBottom = 5.px
            fontSize = 14.px
        }
        type = InputType.text
        value = name
        onChange = { event ->
            name = event.target.value
        }
    }
}