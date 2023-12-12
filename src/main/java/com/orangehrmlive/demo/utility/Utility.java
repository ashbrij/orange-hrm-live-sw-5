package com.orangehrmlive.demo.utility;

import com.google.common.base.Function;
import com.orangehrmlive.demo.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Utility extends ManageBrowser {
    /*Utility Class extends to ManageDriver for the driver to finding locators
     *All common methods are fixed in the utility Class.
     *
     * This method will generate random number
     */
    public int generateRandomNumber() {
        return (int) (Math.random() * 5000 + 1);

    }

    /**
     * This method will generate random string
     */
    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    //**************************** Click On element *************************************************
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement elementLink = driver.findElement(by);
        elementLink.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }
    //********************************  Get Text From element ****************************************

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    //********************************  Send Text to element ****************************************

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(str);
    }

    //****************************  Return WebElement and List of WebElement ****************************
    /**
     * This method will find the list of WebElements
     */
    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will find one WebElement
     */

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    //******************************  clear Text from previous data ******************************

    /**
     * This method will clear the text field
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    public void clearTextFromField(WebElement element) {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }


    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }
    public void clearTextField(WebElement element) {
        element.clear();
    }

    /**
     * This method will send the TAB or ENTER key text field
     */
    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(Keys.TAB);
        //driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public void sendTabAndEnterKey(WebElement element) {
       element.sendKeys(Keys.TAB);
      // element.sendKeys(Keys.ENTER);
    }
    //*************************** Alert Methods ***************************************//

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }
    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectByValueFromDropDown(WebElement element, String value) {
        new Select(element).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    public void selectByIndexFromDropDown(WebElement element, int index) {
        new Select(element).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    public void selectByContainsTextFromDropDown(WebElement element, String text) {
        List<WebElement> allOptions = new Select(element).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }

    /**
     * //When we do not have select tag for dropdown then we use this method
     */
    public void dynamicListDropDown(By by, String text){
        List<WebElement> dynamicList = driver.findElements(by);
        for (int i = 0; i < dynamicList.size(); i++){
            String option = dynamicList.get(i).getText();
            if (option.contains(text)){
                dynamicList.get(i).click();
                break;
            }
        }
    }
    public void dynamicListDropDown(WebElement element, String text) {
        List<WebElement> dynamicList = (List<WebElement>) element;
        for (int i = 0; i < dynamicList.size(); i++) {
            String option = dynamicList.get(i).getText();
            if (option.contains(text)) {
                dynamicList.get(i).click();
                break;
            }
        }
    }


//    public void dynamicListDropDown(By by, String text){
//        sendTextToElement(by, text);
//        List<WebElement> dynamicList = driver.findElements(By.xpath("//xpath_of_dropdown_options"));
//        for (WebElement option : dynamicList) {
//            String optionText = option.getText();
//            System.out.println("Dropdown option: " + optionText);
//            if (optionText.contains(text)) {
//                option.click();
//                break;
//            }
//        }
//    }

//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until visibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * This method is for fluentWait
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //***************************** Is Display Methods **********************************************//
    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method will verify that element is displayed
     */
    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : expectedText + "Text is not found";
        return true;
    }

    public boolean isTextDisplayed(WebElement element, String expectedText) {
        boolean actualText = (element.getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : expectedText + "Text is not found";
        return true;
    }

    //************************** ScreenShot Methods *********************************************//
    /**
     * This method will take screenshot
     */
    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/demo/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/main/java/com/demo/nopcommerce/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    /**
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
    //************************** ArrayList Methods *********************************************//

    /**
     * This method will get arrayList from web elements
     */
    public ArrayList<String> getArrayListFromWebElements(List<WebElement> listOfElements) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            arrayList.add(element.getText());
        }
        return arrayList;
    }

    /**
     * This method will verify the ArrayList products and print the result
     */
    public String verifyTheProductArrangementInArrayList(By by) {
        System.out.println("Product List after sortBy: " + getTextFromElement(by));
        return getTextFromElement(by);
    }
    public String verifyTheProductArrangementInArrayList(WebElement element) {
        System.out.println("Product List after sortBy: " + getTextFromElement(element));
        return getTextFromElement(element);
    }

    /**
     * This method will get the arraylist of our choice form dropdown menu list
     */

    public void getArrayListOfProductsInChoice(By by) {
        List<WebElement> products = findElementsList(by);

        ArrayList<String> actualSortByProduct = new ArrayList<>();
        for (WebElement element : products) {
            String[] array = element.getText().split("Ex Tax:");
            actualSortByProduct.add(String.valueOf(Double.valueOf(array[0].substring(1).replaceAll(",", ""))));
        }

        System.out.println("Before sorting: " + actualSortByProduct);
        Collections.sort(actualSortByProduct, Collections.reverseOrder());
        System.out.println("After sorting: " + actualSortByProduct);

        ArrayList<String> afterSortByProduct = new ArrayList<>(actualSortByProduct);

        System.out.println("Expected result: " + afterSortByProduct);

    }

//**************************************** Date Picker Method   ********************************************************

    /**
     * This method will select the date from calendar
     */
    public void datePicker() {
        String year = "2025";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//span[@class = 'input-group-btn']//button[@class = 'btn btn-default']")); // open the calendar
        while (true) {
            //inspect April 2021
            String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
            }
        }
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    public void selectDeliveryDate(String day, String month, String year) throws InterruptedException {
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@colspan='5']"));

        while (true) {
            String y = getTextFromElement(By.xpath("//div[@class='datepicker-months'] //th[@class='picker-switch']"));
            if (y.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-months']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        clickOnElement(By.xpath("//span[normalize-space()='" + month + "']"));
        clickOnElement(By.xpath("//td[@class = 'day' and text() = '" + day + "']"));
    }


    /**
     * This method will get currentUrl
     */
    public String getCurrentUrlForVerification() {
        return driver.getCurrentUrl();
    }


    /**
     * This method will print List of element in Console
     */

    public void listOfProductsElement(By by, String text) {
        List<WebElement> listOfMenuElements = driver.findElements(by);
        for (WebElement element : listOfMenuElements) {
            System.out.println(element.getText());

            if (element.getText().trim().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }
//**************************************************************************************************
    // This method will verify logo is visible
    public void verifyLogoVisible(WebElement element) {
        boolean logoPresent = element.isDisplayed();
        Assert.assertTrue(logoPresent);
        if (!logoPresent) {
            System.out.println("Logo not Visible");
        } else {
            System.out.println("Logo is Visible");
        }
    }


    public void loginToApplication(String username, String password) {
    }

}


