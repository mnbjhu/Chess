import api.Client
import components.input.Button
import components.input.TextInput
import csstype.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import models.LoginDetails
import models.User
import react.*
import react.dom.html.InputType
import util.Constants.Colors
import kotlin.coroutines.CoroutineContext

external interface LoginPageProps : Props{

}

val mainScope = MainScope()


val LoginPage = FC<LoginPageProps> {
    var username by useState("")
    var password by useState("")

    val onSignIn = {
        mainScope.launch {
            Client.instance.post("http://127.0.0.1:8080/api/login"){
                contentType(ContentType.Application.Json)
                setBody(LoginDetails(username, password))
            }
        }
    }


    div {
        className = ClassName("page-container")

        css {
            display = Display.flex
            alignItems = AlignItems.center
            justifyContent = JustifyContent.center
            width = 99.vw
            height = 99.vh
            backgroundColor = Color(Colors.WHITE.toString())
        }
        div {
            className = ClassName("login-form")

            css {
                width = 75.vh
                height = 75.vh
                border = Border(2.px, LineStyle.solid, Color(Colors.LIGHTGREY.toString()))
                borderRadius = 4.px
                display = Display.flex
                alignItems = AlignItems.center
                justifyContent = JustifyContent.center
                flexDirection = FlexDirection.column
            }

            div {
                css {
                    width = 75.pct
                    height = 12.pct
                    marginBottom = 2.pct
                }
                TextInput {
                    type = InputType.text
                    placeholder = "Enter your username"
                    onChange = {
                        username = it
                    }
                }
            }

            div {
                css {
                    width = 75.pct
                    height = 12.pct
                    marginTop = 2.pct
                }
                TextInput {
                    type = InputType.password
                    placeholder = "Enter your password"
                    onChange = {
                        password = it
                    }
                }
            }

            div {
                css {
                    marginTop = 32.px
                    width = 50.pct
                }
                Button {
                    onClick = { onSignIn() }
                    +"Sign In"
                }
            }
        }
    }
}