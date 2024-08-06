import androidx.compose.ui.window.ComposeUIViewController
import com.rkbapps.protfolio.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
