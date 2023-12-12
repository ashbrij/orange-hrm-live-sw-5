package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 2. HomePage - Store OrangeHRM logo, Admin, PIM, Leave,Dashboard, Welcome Text locatores
 * and create appropriate methods for it.
 */
public class HomePage extends Utility {
    @CacheLookup
    @FindBy(css = "img[alt='OrangeHRM']")
    WebElement orangeHrmLogo;

    @CacheLookup
    @FindBy(xpath ="//span[normalize-space()='Admin']" )
    WebElement clickOnAdminLink;

    @CacheLookup
    @FindBy(xpath ="//span[normalize-space()='PIM']")
    WebElement clickOnPimLink;

    @CacheLookup
    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement clickOnLeaveLink;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement clickOnDashboardLink;

    @CacheLookup
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement verifyWelcomePaul;

    @CacheLookup
    @FindBy(xpath = ("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']"))
    WebElement userProfileLogo;

    public void clickOnUserProfileLogo() {
        mouseHoverToElementAndClick(userProfileLogo);
    }


    public String orangeHrmLogo() {
        CustomListeners.test.log(Status.PASS, "Orange Hrm Logo Displayed");
        return getTextFromElement(orangeHrmLogo);
    }
    public void clickOnAdminLink() {
        CustomListeners.test.log(Status.PASS, "Clicked on Admin link");
        clickOnElement(clickOnAdminLink);
    }
    public void clickOnPimLink() {
        CustomListeners.test.log(Status.PASS, "Clicked on Pim link");
        clickOnElement(clickOnPimLink);
    }

    public void clickOnLeaveLink(){
        CustomListeners.test.log(Status.PASS, "Clicked on Leave link");
        clickOnElement(clickOnLeaveLink);
    }
    public void clickOnDashboardLink(){
        CustomListeners.test.log(Status.PASS, "Clicked on Dashboard link");
        clickOnElement(clickOnDashboardLink);
    }
    public String verifyWelcomePaul() {
        CustomListeners.test.log(Status.PASS, "Welcome Text verified");
        return getTextFromElement(verifyWelcomePaul);
    }

}
