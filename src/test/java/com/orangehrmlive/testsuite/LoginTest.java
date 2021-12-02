package com.orangehrmlive.testsuite;

import com.orangehrmlive.pages.DashboardPage;
import com.orangehrmlive.pages.HomePage;
import com.orangehrmlive.pages.LoginPage;
import com.orangehrmlive.testbase.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test
    public void verifyUserShouldLoginSuccessfully(){
        /*
           Enter username
           Enter password
           Click on Login Button
           Verify "WelCome" Message
         */
        loginPage.enterTheUsernameInTheUsernameField();
        loginPage.enterThePasswordInThePasswordField();
        loginPage.clickOnTheLoginButton();
        homePage.verifyTheWelcomeMessage();
    }

    @Test
    public void verifyThatTheLogoDisplayOnHomePage(){
        /*
           Login To The application
           Verify Logo is Displayed
         */
        verifyUserShouldLoginSuccessfully();
        homePage.verifyTheOrangeHRMLogo();

    }

    @Test
    public void verifyUserShouldLogOutSuccessfully(){
        /*
           Login To The application
         Click on User Profile logo
         Mouse hover on "Logout" and click
         Verify the text "Login Panel" is displayed
         */
        verifyUserShouldLoginSuccessfully();
        homePage.clickOnTheUserProfileLogo();
        homePage.mouseHoverOnLogoutAndClick();
        loginPage.verifyTheLoginPanelText();



    }
}
