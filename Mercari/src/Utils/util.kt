import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
class utilFunClass {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun utilFun() {
        // Launch the app Compose activity
        composeTestRule.setContent {
            MercariApp()
        }
        // Function validates the presence of the node element and returns the value
        fun isNodeVisible(node: String) {
            return composeTestRule.onNodeWithText("$node").assertExists()
        }
        // Function validates the presence of the composable element and returns the value
        fun performClickOnNodeElement (node:String) {
            return composeTestRule.onNodeWithText("$node").performClick()
        }
    }
