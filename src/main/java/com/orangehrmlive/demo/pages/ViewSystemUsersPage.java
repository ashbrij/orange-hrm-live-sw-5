package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 5.ViewSystemUsersPage - System Users Text, Username Field, User Roll dropDown,
 * Employee Name Field,
 * Status Drop Down, Search Button, Reset Button, Add Button and Delete Button locators and it's
 * actions
 */
public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement verifySystemUsersText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement clickOnDropdownUserRoleButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text-input'][normalize-space()='Admin']")
    WebElement userRollDropdownButton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement ananyaDash;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "//i[@class= 'oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    WebElement clickOnStatusDropDownButton;
    @CacheLookup
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusUserDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement clickOnSearchButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement clickOnResetButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement clickOnAddButton;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement clickOnDeleteButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']" )
    WebElement clickOnYesDeleteButton;

    public void addEmployeeName(String name) {
        sendTextToElement(ananyaDash, name);
    }

    public void addUserName(String user) {
        sendTextToElement(userName, user);
    }
    public String verifySystemUsersText() {
        CustomListeners.test.log(Status.PASS, "Orange Hrm Logo Displayed");
        return getTextFromElement(verifySystemUsersText);
    }

    public void enterUsername(String username) {
        CustomListeners.test.log(Status.PASS, "Entered Username");
        sendTextToElement(enterUsername, username);
    }
    public void clickOnDropdownUserRoleButton(){
        CustomListeners.test.log(Status.PASS, "User role dropdown clicked");
        mouseHoverToElementAndClick(clickOnDropdownUserRoleButton);
    }
    public void selectSearchUserRole() {
        CustomListeners.test.log(Status.PASS, "Role selected");
        mouseHoverToElementAndClick(userRollDropdownButton);
    }

//    public void enterEmployeeName(String name) {
//        CustomListeners.test.log(Status.PASS, "Entered employee name");
//        selectByValueFromDropDown(enterEmployeeName, name);
//    }

    public void clickOnStatusDropDownButton(){
        CustomListeners.test.log(Status.PASS, "DropDown Clicked");
        mouseHoverToElementAndClick(clickOnStatusDropDownButton);
    }

    public void statusUserDropdown() {
        CustomListeners.test.log(Status.PASS, "Status user drop down enabled");
        mouseHoverToElementAndClick(statusUserDropdown);
    }

    public void clickOnSearchButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on search button");
        clickOnElement(clickOnSearchButton);
    }

    public void clickOnResetButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on reset button");
        clickOnElement(clickOnResetButton);
    }

    public void clickOnAddButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on Add button");
        clickOnElement(clickOnAddButton);
    }
    public void clickOnDeleteButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on Delete button");
        clickOnElement(clickOnDeleteButton);
    }

    public void clickOnYesDeleteButton(){
        clickOnElement(clickOnYesDeleteButton);
    }

}

