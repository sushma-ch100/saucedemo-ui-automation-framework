package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlowTest() {

        LoginPage loginPage = new LoginPage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);

        // Login
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.urlContains("inventory"));
        assertTrue(driver.getCurrentUrl().contains("inventory"));

        // Add product to cart
        productsPage.addBackpackToCart();
        assertEquals(productsPage.getCartBadgeCount(), "1");

        // Go to cart
        productsPage.goToCart();
        wait.until(ExpectedConditions.urlContains("cart"));
        assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack");

        // Go to checkout info page
        cartPage.clickCheckout();
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));

        // Enter checkout details
        checkoutPage.enterCheckoutDetails("Sushma", "QA", "12345");
        checkoutPage.clickContinue();

        // Checkout overview page
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));

        assertEquals(checkoutPage.getItemTotal(), "Item total: $29.99");
        assertTrue(checkoutPage.getTax().contains("Tax: $"));
        assertTrue(checkoutPage.getTotal().contains("Total: $"));

        // Finish order
        checkoutPage.clickFinish();

        assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}
