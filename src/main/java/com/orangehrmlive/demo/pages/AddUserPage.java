package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 6.AddUserPage - User Role Drop Down, Employee Name, Username, Status Drop Down,
 * Password, Confirm Password,
 * Save and Cancle Button Locators and it's actions
 */
public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement verifyAddUserText;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
    WebElement mouseHoverOnUserRole;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    WebElement userRollDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement addEmployeeName;
    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement dropDownSelectStatus;


    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement statusDropdownOnAddUserPage;

    @CacheLookup
    @FindBy(xpath = "//select[@id='systemUser_status']")
    WebElement statusDropdown;


    @CacheLookup
    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement enterPassword;


    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement clickOnSaveButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement clickOnAddButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement clickOnCancelButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'oxd-toast-content oxd-toast-content--success']")
    WebElement getTextForSuccessfullyMessageAfterSavedAddedUser;


    public String verifyAddUserText() {
        CustomListeners.test.log(Status.PASS, "Add User text verified");
        return getTextFromElement(verifyAddUserText);
    }

    public void mouseHoverOnUserRole() {
        mouseHoverToElementAndClick(mouseHoverOnUserRole);
    }

    public void selectOnUserRoleDropDown() {
        CustomListeners.test.log(Status.PASS, "Admin role selected");
        mouseHoverToElementAndClick(userRollDropdown);
    }
    public void dropDownSelectStatus() {
        CustomListeners.test.log(Status.PASS, "Enabled role selected");
        mouseHoverToElementAndClick(dropDownSelectStatus);
        //  Select select = new Select(dropDownSelectStatus);
        //  select.selectByValue("statusDropdownOnAddUserPage");
    }

    public void statusDropdownOnAddUserPage(){
        CustomListeners.test.log(Status.PASS, "Status Roll Drop Down Enabled");
        clickOnElement(statusDropdownOnAddUserPage);
    }


    public void addEmployeeName(String employeeName) {
        CustomListeners.test.log(Status.PASS, "Add employee name");
        sendTextToElement(addEmployeeName, employeeName);
    }
    public void employeeName(){
        mouseHoverToElementAndClick(employeeName);
    }
    public void enterUsername(String username) {
        CustomListeners.test.log(Status.PASS, "Add username");
        sendTextToElement(enterUsername, username);

    }


    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS, "Enter password");
        sendTextToElement(enterPassword, password);
    }

    public void confirmPassword(String confirmPassword) {
        CustomListeners.test.log(Status.PASS, "Confirm password");
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    public void clickOnSaveButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on Save button");
        clickOnElement(clickOnSaveButton);
    }
    public void clickOnAddButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on Add button");
        clickOnElement(clickOnAddButton);
    }
    public void clickOnCancelButton() {
        CustomListeners.test.log(Status.PASS, "Clicked on Cancel button");
        clickOnElement(clickOnCancelButton);
    }

    public String getTextForSuccessfullyMessageAfterSavedAddedUser() {
        CustomListeners.test.log(Status.PASS, "Successfully saved text displayed");
        return getTextFromElement(getTextForSuccessfullyMessageAfterSavedAddedUser);

    }


}
