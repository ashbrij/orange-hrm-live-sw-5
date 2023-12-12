package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * 1.UsersTest
 * Inside UsersTest class create following testmethods
 * 1.adminShouldAddUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * click On "Add" button
 * Verify "Add User" Text
 * Select User Role "Admin"
 * enter Employee Name "Ananya Dash"
 *
 * enter Username
 * Select status "Disable"
 * enter psaaword
 * enter Confirm Password
 * click On "Save" Button
 * verify message "Successfully Saved"
 * 2. searchTheUserCreatedAndVerifyIt().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Satatus
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * 3. verifyThatAdminShouldDeleteTheUserSuccessFully().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username
 * Select User Role
 * Select Satatus
 * Click on "Search" Button
 * Verify the User should be in Result list.
 * Click on Check box
 * Click on Delete Button
 * Popup will display
 * Click on Ok Button on Popup
 * verify message "Successfully Deleted"
 * 4. searchTheUserAndVerifyTheMessageRecordFound().
 * Login to Application
 * click On "Admin" Tab
 * Verify "System Users" Text
 * Enter Username <username>
 * Select User Role <userRole>
 * Enter EmployeeName <employeeName>
 * Select Satatus <status>
 * Click on "Search" Button
 * verify message "(1) Record Found"
 * Verify username <username>
 * Click on Reset Tab
 *
 * Data Set
 * username userrole employeeName Status
 * Admin Admin Paul Collings Enable
 * Cassidy.Hope ESS Cassidy Hope Enable
 * Nina.Patel ESS Nina Patel Enable
 * Odis.Adalwin Admin Odis Adalwin Enable
 */
@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    DashboardPage dashboardPage;
    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        dashboardPage = new DashboardPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.ClickOnLoginButton();

        //click On "Admin" Tab
        homePage.clickOnAdminLink();

        //Verify "System Users" Text
        String expected = "System Users";
        String actual = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actual, expected, "Error Message");

        //click On "Add" button

        addUserPage.clickOnAddButton();

        //Verify "Add User" Text
        String expected1 = "Add User";
        Assert.assertEquals(addUserPage.verifyAddUserText(), expected1, "Error Message");

        //Select User Role "Admin"
        addUserPage.mouseHoverOnUserRole();
        Thread.sleep(2000);
        addUserPage.selectOnUserRoleDropDown();

        //enter Employee Name
        addUserPage.addEmployeeName("firstclass  selenium");
        Thread.sleep(2000);
        //Enter employee name
        addUserPage.employeeName();

        //enter Username
        addUserPage.enterUsername("TestUser1");


        //Select status "Disabled"
        addUserPage.dropDownSelectStatus();
        addUserPage.statusDropdownOnAddUserPage();


        //Enter password
        addUserPage.enterPassword("Lisa123");

        //Enter Confirm Password
        addUserPage.confirmPassword("Lisa123");

        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        Thread.sleep(8000);


        //Verify "System Users" Text

        viewSystemUsersPage.enterUsername("TestUser1");

        //Select User Role
        // viewSystemUsersPage.clickOnDropdownUserRoleButton();
        //Thread.sleep(2000);
        //  viewSystemUsersPage.selectSearchUserRole();

        //Select Status


        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        Thread.sleep(2000);
        viewSystemUsersPage.clickOnDeleteButton();
        Thread.sleep(2000);
        //Popup will display

        //Click on Ok Button on Popup
        viewSystemUsersPage.clickOnYesDeleteButton();
        //verify message "Successfully Deleted"

    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.ClickOnLoginButton();

        //click On "Admin" Tab
        homePage.clickOnAdminLink();

        //Verify "System Users" Text
        String expected = "System Users";
        String actual = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actual, expected, "Error Message");

        //Enter Username
        viewSystemUsersPage.enterUsername("Admin");

        //Select User Role
        // viewSystemUsersPage.clickOnDropdownUserRoleButton();
        //Thread.sleep(2000);
        //  viewSystemUsersPage.selectSearchUserRole();

        //Select Status


        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        //Verify the User should be in Result list
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.ClickOnLoginButton();

        //click On "Admin" Tab
        homePage.clickOnAdminLink();

        //Verify "System Users" Text
        String expected = "System Users";
        String actual = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actual, expected, "Error Message");
        //click On "Add" button

        addUserPage.clickOnAddButton();

        //Verify "Add User" Text
        String expected1 = "Add User";
        Assert.assertEquals(addUserPage.verifyAddUserText(), expected1, "Error Message");

        //Select User Role "Admin"
        addUserPage.mouseHoverOnUserRole();
        Thread.sleep(2000);
        addUserPage.selectOnUserRoleDropDown();

        //enter Employee Name
        addUserPage.addEmployeeName("firstclass  selenium");
        Thread.sleep(2000);
        //Enter employee name
        addUserPage.employeeName();


        //enter Username
        addUserPage.enterUsername("TestUser1");


        //Select status "Disabled"
        addUserPage.dropDownSelectStatus();
        addUserPage.statusDropdownOnAddUserPage();


        //Enter password
        addUserPage.enterPassword("Lisa123");

        //Enter Confirm Password
        addUserPage.confirmPassword("Lisa123");

        //click On "Save" Button
        addUserPage.clickOnSaveButton();
        Thread.sleep(8000);


        //Verify "System Users" Text

        viewSystemUsersPage.enterUsername("TestUser1");

        //Select User Role
        // viewSystemUsersPage.clickOnDropdownUserRoleButton();
        //Thread.sleep(2000);
        //  viewSystemUsersPage.selectSearchUserRole();

        //Select Status


        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();
        Thread.sleep(2000);
        viewSystemUsersPage.clickOnDeleteButton();
        Thread.sleep(2000);
        //Popup will display

        //Click on Ok Button on Popup
        viewSystemUsersPage.clickOnYesDeleteButton();
        //verify message "Successfully Deleted"

    }

    @Test(groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound() {
        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.ClickOnLoginButton();

        //click On "Admin" Tab
        homePage.clickOnAdminLink();
        //Verify "System Users" Text
        String expected = "System Users";
        String actual = viewSystemUsersPage.verifySystemUsersText();
        Assert.assertEquals(actual, expected, "Error Message");

        //Enter Username <username>
        viewSystemUsersPage.enterUsername("krishna1203");
        //Select User Role <userRole>

        //Enter EmployeeName <employeeName>

        //Select Satatus <status>

        //Click on "Search" Button
        viewSystemUsersPage.clickOnSearchButton();

        //verify message "(1) Record Found"

        //Verify username <username>

        //Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();
    }

}