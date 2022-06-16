package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public void capabilities(String scenarioName) throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String os = System.getProperty("os.name").toLowerCase();

        capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, Constants.APP_WAIT_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Constants.NEW_COMMAND_TIMEOUT);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", Constants.SERVER_LUANCH_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability("ignoreUnimportantViews", true);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("autoGrantPermissions", true);

        capabilities.setCapability("systemPort", ThreadManager.getSystemPort());
        capabilities.setCapability(MobileCapabilityType.APP, Constants.APK_FULLPATH);
        capabilities.setCapability(MobileCapabilityType.UDID, ThreadManager.getDeviceUdid());
        capabilities.setCapability("chromedriverExecutableDir", Constants.CHROMEDRIVER_DIRECTORY_PATH);

        ThreadManager.setDriver(new AndroidDriver<>(ThreadManager.getAppiumLocalService().getUrl(), capabilities));
        ThreadManager.getDriver().manage().timeouts().implicitlyWait(Constants.MINIMUM_WEBDRIVER_WAIT_DURATION, TimeUnit.SECONDS);
    }

    /**
     * Quit driver instance
     */
    public void tearDown() {
        if (ThreadManager.getDriver() != null) {
            ThreadManager.getDriver().quit();
        }
    }
}
