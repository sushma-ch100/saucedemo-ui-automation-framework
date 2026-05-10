package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartPage {

    WebDriver driver;
    WebDriverWait wait;
    public CartPage(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
}

    By cartItem = By.className("inventory_item_name");
    By checkoutButton = By.id("checkout");

public String getCartItemName() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem)).getText();
}

public void clickCheckout() {
    wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
}
}