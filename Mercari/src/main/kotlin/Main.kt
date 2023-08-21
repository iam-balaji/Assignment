import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import Utils.UtilFunctions.isNodeVisible
import Utils.UtilFunctions.performClickOnNodeElement
import Utils.UtilFunctions.isNodeVisibleWithContentDescription
import Utils.UtilFunctions.performInputText
class MercariApp {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun AddToCartAndCheckoutOnMercariApp() {
        // Launch the app Compose activity
        composeTestRule.setContent {
            MercariApp()
        }

        // Navigate to the product page by performing click
        findProductAndNavigateToProductPage("Sauce Labs Backpack")
        performClickOnNodeElement("Sauce Labs Backpack")

        //  adding the product to cart
        performClickOnNodeElement("Add to Cart")

        // Navigate to the product page by performing click
        findProductAndNavigateToProductPage("Sauce Labs Bike Light")
        performClickOnNodeElement("Sauce Labs Bike Light")

        //  adding the product to cart
        performClickOnNodeElement("Add to Cart")

        // Verify that the cart icon is present
        isNodeVisibleWithContentDescription("Cart")

        // Simulate clicking on the cart icon
        performClickOnNodeElement("Cart")

        // Verify that the cart screen is displayed
        isNodeVisible("Your Cart")

        // Simulate clicking on the "Checkout" button
        isNodeVisible("Checkout")
        performClickOnNodeElement("Checkout")

        // Verify that the checkout screen is displayed
        isNodeVisible("Checkout: Your Information")

        //Add address information
        performInputText("First Name", "John")
        performInputText("Last Name", "Doe")
        performInputText("Zip/Postal Code", "98101")

        // Continue to place order
        isNodeVisible("Continue")
        performClickOnNodeElement("Continue")

        // Verify that the order confirmation screen is displayed
        isNodeVisible("Checkout: Overview")

        // Confirm Order Placement
        isNodeVisible("Finish")
        performClickOnNodeElement("Finish")

        // Verify that the order confirmation screen is displayed
        isNodeVisible("Checkout: Complete!")
        isNodeVisible("Thank you for your order!")
    }

    private fun findProductAndNavigateToProductPage(productName:String) : Boolean {
        var productVisible : Boolean = false
        if (isNodeVisible(productName)) {
            performClickOnNodeElement(productName)
            productVisible = true
        }
        else {
            throw Exception("Product $productName is not found on the page")
        }
        return productVisible
    }
}
