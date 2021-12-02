package com.orangehrmlive.pages;

import com.orangehrmlive.utility.Utility;
import org.openqa.selenium.By;

public class AddUserPage extends Utility {

    /*
    6.AddUserPage - User Role Drop Down, Employee Name, Username, Status Drop Down, Password, Confirm Password,
      Save and Cancle Button Locators and it's actions
     */

    By userRoleDropDown = By.xpath("//select[@id='systemUser_userType']");
    By employeeName = By.xpath("//input[@id='systemUser_employeeName_empName']");
    By userName = By.xpath("//input[@id='systemUser_userName']");
    By statusDropDown = By.xpath("//select[@id='systemUser_status']");
    By password = By.xpath("//input[@id='systemUser_password']");
    By confirmPassword = By.xpath("//input[@id='systemUser_confirmPassword']");
    By saveButton = By.xpath("//input[@id='btnSave']");
    By cancelButton = By.xpath("");

    public void selectUserRoleAsAdmin(String userRole){
        doSelectByVisibleTextFromDropDown(userRoleDropDown, userRole);
    }

    public void putEmployeeNameInTheEmployeeNameField(String empFullName){
        doSendTextToElement(employeeName, empFullName);
    }

    public void putUserNameInTheUserNameField(String empUserName){
        doSendTextToElement(userName, empUserName);
    }

    public void selectStatusAsDisabled(String selectStatus){
        doSelectByVisibleTextFromDropDown(statusDropDown, selectStatus);
    }

    public void enterPasswordInPasswordField(){
        doSendTextToElement(password, "Adhfaughua125£$£^");
    }

    public void enterConfirmationPasswordInTheConfirmPasswordField(){
        doSendTextToElement(confirmPassword,"Adhfaughua125£$£^" );
    }

    public void clickOnSaveButton(){
      doWaitUntilVisibilityOfElementLocated(saveButton, 50).click();
    }










}
