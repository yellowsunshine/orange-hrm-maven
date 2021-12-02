package com.orangehrmlive.pages;

import com.orangehrmlive.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Utility {
    /*
    2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
       and create appropriate methods for it.
     */

    By orangeHRMLogo = By.xpath("//img[@alt='OrangeHRM']");
    By admin = By.xpath("//b[normalize-space()='Admin']");
    By pIM = By.xpath("");
    By leave = By.xpath("");
    By dashboard = By.xpath("");
    By welcomeText = By.xpath("//a[@id='welcome']");
    By logOut = By.xpath("//a[normalize-space()='Logout']");



    public void verifyTheWelcomeMessage(){
        String s1 = "Welcome Paul";
        String expectedMessage = s1.substring(0, 6);
        String s2 = doGetTextFromElement(welcomeText);
        String actualMessage = s2.substring(0,6);
        doVerifyElements(expectedMessage,actualMessage, "Welcome Message is displayed incorrectly" );
    }

    public void verifyTheOrangeHRMLogo(){
       //verificationMethodUsingWait("", orangeHRMLogo, 50);
       boolean logoPresent = driver.findElement(orangeHRMLogo).isDisplayed();
       Assert.assertTrue(logoPresent);
    }

    public void clickOnTheUserProfileLogo(){
        doClickOnElement(welcomeText);
    }

    public void mouseHoverOnLogoutAndClick(){
        doMouseHoverNoClick(logOut);
        doWaitUntilVisibilityOfElementLocated(logOut, 20).click();
    }

    public void clickOnAdminTabFromHomePage(){
        doClickOnElement(admin);
    }




}
