package utilities;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class AppiumHelpers {

    AppiumDriver<WebElement> driver;
    JavaHelpers helper;

    public AppiumHelpers(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        helper = new JavaHelpers();
    }

    // Take screenshot

    /**
     * Take screenshot of the web page
     *
     * @param fileName screenshot file name
     * @throws IOException
     */
    public void takeScreenshot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(scrFile,
                new File(Constants.SCREENSHOT_LOCATION + fileName + helper.getTimeStamp("_yyyyMMdd_HHmmss") + ".png"));
    }


    //Elements

    /**
     * Enter text to input field
     *
     * @param e     WebElement object
     * @param text  input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(WebElement e, String text, boolean clear) {
        e = waitTillElementIsClickable(e);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    /**
     * Get Text from field
     *
     * @param e       WebElement object
     * @param message
     * @param b
     * @return text from field
     */
    public String getText(WebElement e, String message, boolean b) {
        return waitTillElementIsVisible(e).getText().trim();
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     */
    public void clickOn(WebElement e) {
        waitTillElementIsClickable(e).click();
    }

    /**
     * Click on Element
     *
     * @param e WebElement object
     */
    public void click(WebElement e) {
        e.click();
    }

    /**
     * method verify whether element is present on screen
     *
     * @param targetElement element to be present
     * @return true if element is present else throws exception
     */
    public boolean isElementPresent(By targetElement) {
        return !driver.findElements(targetElement).isEmpty();
    }


    //Waits

    /**
     * To wait until element is clickable
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    /**
     * o wait until element is visible
     *
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_WAIT_DURATION);
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * Waiting before performing next action
     *
     * @param seconds provide duration e.g. 1,2 etc
     * @throws InterruptedException
     */
    public void hardWait(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    /**
     * Scroll to element by text
     *
     * @param elementText element text
     */
    public void scrollToElementByText(String elementText) {
        String locatorText = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementText + "\"));";
        driver.findElement(MobileBy.AndroidUIAutomator(locatorText));
    }

    public void pushFile(String s, File file) {

    }
}