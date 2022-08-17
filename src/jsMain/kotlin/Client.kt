import kotlinx.browser.document
import position.Bitboard
import react.create
import react.dom.client.createRoot
import position.Position;

fun main() {
    val container = document.createElement("div")
    document.body!!.appendChild(container)

    val pos = Position()

    print(pos);


    val welcome = Welcome.create {
        name = "Kotlin/JS"
    }
    createRoot(container).render(welcome)
}