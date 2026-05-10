package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.login("standard_user", "secret_sauce");

        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.login("invalid_user", "wrong_password");
        pause(2);
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match"));
    }
}