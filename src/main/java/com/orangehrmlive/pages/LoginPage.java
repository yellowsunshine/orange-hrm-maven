package com.orangehrmlive.pages;

import com.orangehrmlive.utility.Utility;
import org.openqa.selenium.By;

public class LoginPage extends Utility {
    /*
     * 1.LoginPage - Store username, password, Login Button and LOGIN Panel text Locators
     * and create appropriate methods for it.
     */
    By userName = By.xpath("//input[@id='txtUsername']");
    By passWord = By.xpath("//input[@id='txtPassword']");
    By loginButton = By.xpath("//input[@id='btnLogin']");
    By loginPanel = By.xpath("//div[@id='logInPanelHeading']");

    public void enterTheUsernameInTheUsernameField(){
        doSendTextToElement(userName, "Admin");
    }

    public void enterThePasswordInThePasswordField(){
        doSendTextToElement(passWord, "admin123");
    }

    public void clickOnTheLoginButton(){
        doClickOnElement(loginButton);
    }

    public void verifyTheLoginPanelText(){
        verificationMethodUsingWait("LOGIN Panel", loginPanel, 50);

    }


}
