import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import info.javaway.spend_sense.greeting
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.root.compose.RootScreen

fun main() {
    greeting()
    application {
        val rootViewModel = RootViewModel()
        Window(
            onCloseRequest = { exitApplication() },
            state = rememberWindowState().apply { size = DpSize(200.dp, 200.dp) },
            title = "SpendSense"
        ) {
            RootScreen(rootViewModel = rootViewModel)
        }
    }
}