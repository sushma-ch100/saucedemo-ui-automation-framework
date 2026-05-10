package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    // 🔥 Add to cart with strong wait
    public void addBackpackToCart() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addBackpackButton));
        addButton.click();

        // wait for cart badge to appear (confirms action completed)
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
    }

    // 🔥 Navigate to cart with wait
    public void goToCart() {
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cart.click();

        // wait for cart page to load
        wait.until(ExpectedConditions.urlContains("cart"));
    }

    // 🔥 Get badge count safely
    public String getCartBadgeCount() {
        WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return badge.getText();
    }
}