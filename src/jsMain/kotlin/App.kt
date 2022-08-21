import react.FC
import react.Props
import position.Parser
import position.Position
import react.createElement
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter


external interface AppProps : Props {
}

val App = FC<AppProps> {
    Parser.Companion.ToPosition.fen(Position.INITIAL_POSITION) { str -> console.log(str) }

    BrowserRouter {
        Routes {
            Route {
                path = "/app/login"
                element = createElement(LoginPage)
            }
        }
    }
}