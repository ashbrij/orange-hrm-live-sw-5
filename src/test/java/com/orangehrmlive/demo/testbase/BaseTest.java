package com.orangehrmlive.demo.testbase;

import com.orangehrmlive.demo.propertyreader.PropertyReader;
import com.orangehrmlive.demo.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");
//    public String randomEmail = randomEmail();
//    By emailAddressOption = By.id("Email");
//    public void enterEmailAddress(){
//        sendTextToElement(emailAddressOption, randomEmail);
//    }
//    private static String randomEmail() {
//        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
//    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        selectBrowser(browser);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        closeBrowser();
    }

}
