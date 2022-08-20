import csstype.px
import react.FC
import react.Props
import emotion.react.css
import game.Chess
import position.Parser
import position.Position
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.pre
import react.useState

external interface WelcomeProps : Props {
    var name: String
}

val Welcome = FC<WelcomeProps> { props ->
    var name by useState(props.name)
    val chess = Chess()

    Parser.Companion.ToPosition.fen(Position.INITIAL_POSITION, { str -> console.log(str) })

    pre {
        css {
            padding = 5.px
        }
        +JSON.stringify(chess.board, null, 2)
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