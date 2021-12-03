package com.orangehrmlive.pages;

import com.orangehrmlive.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminPage extends Utility {
    /*
    4.AdminPage - UserManagement, Job, Organization Tabs Locators and it's actions
     */

    By userManagement = By.xpath("//a[@id='menu_admin_UserManagement']");
    By job = By.xpath("//a[@id='menu_admin_Job']");
    By organization = By.xpath("//a[@id='menu_admin_Organization']");
    By systemUsersWelcomeText = By.cssSelector("div[class='head'] h1");
    By addButton = By.xpath("//input[@id='btnAdd']");
    By addUserText = By.xpath("//h1[@id='UserHeading']");
    By successfullySavedMessage = By.xpath("//div[@id='successBodyEdit']");
    By userName = By.xpath("//input[@id='searchSystemUser_userName']");
    By userRole = By.xpath("//select[@id='searchSystemUser_userType']");
    By status = By.xpath("//select[@id='searchSystemUser_status']");
    By searchButton = By.xpath("//input[@id='searchBtn']");
    By anayaDash9 = By.partialLinkText("AnayaDas");
    By checkBox = By.xpath("//tr[@class='odd']//td//input[@type='checkbox' and @name='chkSelectRow[]']");
    By deleteButton = By.xpath("//input[@id='btnDelete']");


    public void verifyTheSystemUsersWelcomeText(){
        verificationMethodUsingWait("System Users", systemUsersWelcomeText, 100);
    }

    public void clickOnTheAddButton(){
        doClickOnElement(addButton);
    }

    public void verifyTheAddUserText(){
        verificationMethodUsingWait("Add User", addUserText, 50);
    }

    public void verifyTheSuccessFullySavedMessage() throws InterruptedException {
        String message = doGetTextFromElement(successfullySavedMessage);
        //doVerifyElements("Successfully saved", message, "Message is not displayed");

    }

    public void enterUserNameInTheUserNameField(String uName){
        doSendTextToElement(userName,uName );
    }

    public void selectUserRole(String role){
        doSelectByVisibleTextFromDropDown(userRole,role );
    }

    public void selectUserStatus(String uStatus){
        doSelectByVisibleTextFromDropDown(status, uStatus);
    }

    public void clickOnSearchButton(){
        doClickOnElement(searchButton);
    }

    public void verifyUsersNameIsInTheResultsTable(String uName){
        verificationMethodUsingWait(uName, anayaDash9, 100);

    }
    public void clickOnTheCheckBox(){
        doClickOnElement(checkBox);
    }

    public void clickOnDeleteButton(){
        doClickOnElement(deleteButton);
    }

    public void clickOnOKButtonOfPopUp(){
        doAcceptAlert();
    }


}
