package com.parabank.pages;

import com.parabank.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//input[@type=\"submit\"]");
    private final By loginError = By.xpath("//p[@class=\"error\"]");
    private final By logOutButton = By.linkText("Log Out");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String userNameText) {
        enterText(username, userNameText);
    }

    public void enterPassword(String passwordText) {
        enterText(password, passwordText);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(loginError);
    }

    public boolean displayElement() {
        return elementIsDisplayed(logOutButton);
    }
}
