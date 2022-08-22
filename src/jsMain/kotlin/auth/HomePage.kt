import api.Client
import components.input.Button
import components.input.TextInput
import csstype.*
import react.dom.html.ReactHTML.div
import emotion.react.css
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import models.LoginDetails
import react.*
import react.dom.html.InputType
import util.Constants.Colors

external interface HomePageProps : Props{

}

val homePage = FC<HomePageProps> {
    div {
        +"Welcome"
    }
}