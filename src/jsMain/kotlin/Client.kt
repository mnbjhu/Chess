import kotlinx.browser.document
import kotlinx.browser.window
import position.Bitboard
import react.create
import react.dom.client.createRoot
import position.Position;

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)


    val welcome = Welcome.create {
        name = "Kotlin/JS"
    }
    createRoot(container).render(welcome)
}