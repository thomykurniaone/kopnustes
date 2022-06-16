package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.AppiumHelpers;
import utilities.Constants;
import utilities.DriverManager;
import utilities.ThreadManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks
{
    DriverManager drivermanager = new DriverManager();

    @Before(order = 1)
    public void setUp(Scenario scenario) throws IOException, InterruptedException
    {
        drivermanager.capabilities(scenario.getName());
        new AppiumHelpers(ThreadManager.getDriver()).hardWait(5);//Waiting to get device in good state to avoid any issues
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            byte[] screenshotBytes = ((TakesScreenshot) ThreadManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png",scenario.getName());
        }

        drivermanager.tearDown();
    }

    @Before(order=0)
    public void resetChrome() throws InterruptedException {

        AppiumDriver<WebElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("fastReset", true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", Constants.SERVER_LUANCH_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("deviceOrientation","portrait");
        capabilities.setCapability("browserName", "kopnus");
        capabilities.setCapability("AppPackage", "com.android.kopnus");
        capabilities.setCapability("AppActivity", "com.google.android.apps.kopnus.Main");
        capabilities.setCapability("systemPort", ThreadManager.getSystemPort());
        capabilities.setCapability(MobileCapabilityType.UDID, ThreadManager.getDeviceUdid());
        capabilities.setCapability("chromedriverExecutableDir", Constants.CHROMEDRIVER_DIRECTORY_PATH);
        driver = new AndroidDriver<>(ThreadManager.getAppiumLocalService().getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(Constants.MINIMUM_WEBDRIVER_WAIT_DURATION, TimeUnit.SECONDS);
        driver.quit();
    }

}