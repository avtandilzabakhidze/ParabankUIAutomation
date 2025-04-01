package com.parabank.steps;

import com.parabank.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    public void login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void verifySuccessfulLogin() {
        Assert.assertTrue(loginPage.displayElement(), "\n Login failed \n");
    }

    public void verifyIncorrectCredentials() {
        Assert.assertEquals(loginPage.getErrorMessage(),"The username and password could not be verified.", "\n Credentials is valid \n");
    }

    public void verifyEmptyCredentials() {
        Assert.assertEquals(loginPage.getErrorMessage(),"Please enter a username and password.", "\n Credentials is not empty \n");
    }
}
