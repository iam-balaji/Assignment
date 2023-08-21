package Utils

import MercariApp
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class UtilFunctions {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // Function validates the presence of the node element and returns the value
        fun isNodeVisible(node: String) {
            return composeTestRule.waitUntilExists(node)
        }

        // Function validates the presence of the node element and returns the value
        fun isNodeVisibleWithContentDescription(node: String) {
            return composeTestRule.onNodeWithContentDescription(node).assertIsDisplayed()
        }

        // Function validates the presence of the composable element and returns the value
        fun performClickOnNodeElement(node: String) {
            composeTestRule.onNodeWithText(node).performClick()
        }

        // Function validates the presence of the composable element and returns the value
        fun performInputText(fieldName : String, inputText:String) {
            composeTestRule.onNodeWithContentDescription(fieldName).performTextInput(inputText)
        }


    }
}
