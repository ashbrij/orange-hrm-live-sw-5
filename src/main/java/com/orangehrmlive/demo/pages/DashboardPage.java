package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 3.DashboardPage - Dashboard text Locator
 * and create appropriate methods for it.
 */
public class DashboardPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Dashboard']")
    WebElement clickONDashboardLink;
    @CacheLookup
    @FindBy(xpath = "(//h6[normalize-space()='Dashboard'])[1]")
    WebElement verifyDashboardText;


    public String verifyDashboardText() {
        CustomListeners.test.log(Status.PASS, "Dashboard text verified");
        return getTextFromElement(verifyDashboardText);
    }

    public void clickONDashboardLink(){
        clickOnElement(clickONDashboardLink);
    }


}


