package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 4.AdminPage - UserManagement, Job, Organization Tabs Locators and it's actions
 */
public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement clickOnUserManagement;

    @CacheLookup
    @FindBy(xpath = "//a[@id='menu_admin_Job']")
    WebElement clickOnJob;

    @CacheLookup
    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    WebElement clickOnOrganizationLink;

    public void clickOnUserManagement() {
        CustomListeners.test.log(Status.PASS, "Clicked on User Management Link");
        clickOnElement(clickOnUserManagement);

    }
    public void clickOnJob() {
        CustomListeners.test.log(Status.PASS, "Clicked on Job Link");
        clickOnElement(clickOnJob);
    }
    public void clickOnOrganizationLink() {
        CustomListeners.test.log(Status.PASS, "Clicked on  Organization Link");
        clickOnElement(clickOnOrganizationLink);

    }
}
