package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 1.LoginPage - Store username, password, Login Button and LOGIN Panel text Locators
 * and create appropriate methods for it.
 */
public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernamefield;

    @CacheLookup
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordfield;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Login']"))
    WebElement loginButton;


    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Username : Admin']")
    WebElement verifyUsernameAdminText;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Password : admin123']")
    WebElement verifyPasswordadmin123Text;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;
    @CacheLookup
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement verifyLoginPanel;
    @CacheLookup
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement userprofilelogo;

    @CacheLookup
    @FindBy(xpath = ("(//img[@alt='orangehrm-logo'])[2]"))
    WebElement logoElement;
    @CacheLookup
    @FindBy(xpath = ("(//button[normalize-space()='Login'])[1]"))
    WebElement loginPanel;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMessage;

    public void getTextForLoginPanel(String text) {
        verifyThatTextIsDisplayed(loginPanel, text);
    }
    public void getErrorMessage(String text) {
        verifyThatTextIsDisplayed(errorMessage, text);
    }

    public void getLogoElement(String text) {
        verifyThatTextIsDisplayed(logoElement, text);
    }
    public void enterUserName(String username) {
        CustomListeners.test.log(Status.PASS, "Enter Username");
        sendTextToElement(usernamefield, username);
    }

    public void enterPassword(String password) {
        CustomListeners.test.log(Status.PASS, "Enter Username");
        sendTextToElement(passwordfield, password);
    }

    public void ClickOnLoginButton() {
        CustomListeners.test.log(Status.PASS, "Click on Login Button");
        clickOnElement(loginButton);
    }


    public void mouseHoverAndClickOnLogout() {
        mouseHoverToElement(logout);
        mouseHoverToElementAndClick(logout);
    }

    public String verifyUsernameAdminText() {
        CustomListeners.test.log(Status.PASS, "Username verified");
        return getTextFromElement(verifyUsernameAdminText);

    }

    public String verifyPasswordadmin123Text() {
        CustomListeners.test.log(Status.PASS, "Password verified");
        return getTextFromElement(verifyPasswordadmin123Text);

    }

    public String verifyLoginPanel() {
        return getTextFromElement(verifyLoginPanel);

    }
    public void ClickOnUserProfileLogo() {
        clickOnElement(userprofilelogo);
    }

}
