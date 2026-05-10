package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By confirmationMessage = By.className("complete-header");
    By itemTotal = By.className("summary_subtotal_label");
    By tax = By.className("summary_tax_label");
    By total = By.className("summary_total_label");
    

    public void enterCheckoutDetails(String first, String last, String zip) {
        WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(first);

        WebElement lastNameField = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(last);

        WebElement zipField = wait.until(ExpectedConditions.elementToBeClickable(postalCode));
        zipField.click();
        zipField.clear();
        zipField.sendKeys(zip);
    }

    public void clickContinue() {
    WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));

    ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", continueBtn);

    wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
  }
    
    
    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
    }
    public String getItemTotal() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotal)).getText();
}

    public String getTax() 
    {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(tax)).getText();

    }

    public String getTotal() 
    {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(total)).getText();
 }

  }