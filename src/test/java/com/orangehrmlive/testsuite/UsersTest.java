package com.orangehrmlive.testsuite;

import com.google.common.base.Verify;
import com.orangehrmlive.pages.AddUserPage;
import com.orangehrmlive.pages.AdminPage;
import com.orangehrmlive.testbase.TestBase;
import javafx.scene.control.Tab;
import org.testng.annotations.Test;

public class UsersTest extends LoginTest {

    AdminPage adminPage = new AdminPage();
    AddUserPage addUserPage = new AddUserPage();

    String employeeName = "Ananya Dash";
    String employeeUserName = "AnanyaDash12";
    String userRole = "Admin";
    String employeeStatus = "Disabled";

    @Test
    public void adminShouldAddUserSuccessfully() throws InterruptedException {
        /*Login to Application
        	click On "Admin" Tab
	Verify "System Users" Text
	click On "Add" button
	Verify "Add User" Text
	Select User Role "Admin"
	enter Employee Name "Ananya Dash"
	enter Username
	Select status "Disable"
	enter psaaword
	enter Confirm Password
	click On "Save" Button
	verify message "Successfully Saved"
         */
        verifyUserShouldLoginSuccessfully();
        homePage.clickOnAdminTabFromHomePage();
        adminPage.verifyTheSystemUsersWelcomeText();
        adminPage.clickOnTheAddButton();
        adminPage.verifyTheAddUserText();
        addUserPage.selectUserRoleAsAdmin(userRole);
        addUserPage.putEmployeeNameInTheEmployeeNameField(employeeName);
        addUserPage.putUserNameInTheUserNameField(employeeUserName);
        addUserPage.selectStatusAsDisabled(employeeStatus);
        addUserPage.enterPasswordInPasswordField();
        addUserPage.enterConfirmationPasswordInTheConfirmPasswordField();
        addUserPage.clickOnSaveButton();
        adminPage.verifyTheSuccessFullySavedMessage();
    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() {

        //Login to Application
        verifyUserShouldLoginSuccessfully();
        //click On "Admin" Tab
        homePage.clickOnAdminTabFromHomePage();
        //Verify "System Users" Text
        adminPage.verifyTheSystemUsersWelcomeText();
        //Enter Username
        adminPage.enterUserNameInTheUserNameField(employeeUserName);
        //Select User Role
        adminPage.selectUserRole(userRole);
        //Select Status
        adminPage.selectUserStatus(employeeStatus);
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        adminPage.verifyUsersNameIsInTheResultsTable(employeeUserName);

    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() {

        //Login to Application
        verifyUserShouldLoginSuccessfully();
        //click On "Admin" Tab
        homePage.clickOnAdminTabFromHomePage();
        //Verify "System Users" Text
        adminPage.verifyTheSystemUsersWelcomeText();
        //Enter Username
        adminPage.enterUserNameInTheUserNameField(employeeUserName);
        //Select User Role
        adminPage.selectUserRole(userRole);
        //Select Status
        adminPage.selectUserStatus(employeeStatus);
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //Verify the User should be in Result list.
        adminPage.verifyUsersNameIsInTheResultsTable(userRole);
        //Click on Check box
        adminPage.clickOnTheCheckBox();
        //Click on Delete Button
        adminPage.clickOnDeleteButton();
        //Popup will display
        //Click on Ok Button on Popup
        adminPage.clickOnOKButtonOfPopUp();
        //verify message "Successfully Deleted"


    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        //Login to Application
        verifyUserShouldLoginSuccessfully();
        //click On "Admin" Tab
        homePage.clickOnAdminTabFromHomePage();
        //Verify "System Users" Text
        adminPage.verifyTheSystemUsersWelcomeText();
        //Enter Username
        adminPage.enterUserNameInTheUserNameField(employeeUserName);
        //Select User Role
        adminPage.selectUserRole(userRole);
        //Select Status
        adminPage.selectUserStatus(employeeStatus);
        //Click on "Search" Button
        adminPage.clickOnSearchButton();
        //verify message "No Records Found"


    }


}
