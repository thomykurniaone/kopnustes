package utilities;

import java.io.File;

public class Constants {
    public static final String PROPERTYFILE="src/main/resources/constants.properties";

    //Test Run Platform
    public static final String PLATFORM = JavaHelpers.setSystemVariable(PROPERTYFILE ,"Platform");

    //Application details
    public static final String APK_FULLNAME = JavaHelpers.getPropertyValue(PROPERTYFILE, "ApkFullName");
    public static final String APK_FULLPATH = new File("src/main/resources/apk", APK_FULLNAME).getAbsolutePath();
    public static final String APP_WAIT_ACTIVITY = JavaHelpers.getPropertyValue(PROPERTYFILE, "AppWaitActivity");

    //Appium constants
    public static final int WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE, "WebDriverWaitDuration"));
    public static final int MINIMUM_WEBDRIVER_WAIT_DURATION = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE, "MinimumWebDriverWaitDuration"));
    public static final int NEW_COMMAND_TIMEOUT = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE, "NewCommandTimeout"));
    public static final int SERVER_LUANCH_TIMEOUT = Integer.parseInt(JavaHelpers.getPropertyValue(PROPERTYFILE, "ServerLaunchTimeout"));

    //Other
    public static final String SCREENSHOT_LOCATION = JavaHelpers.getPropertyValue(PROPERTYFILE, "ScreenshotLocation");

    //ChromeDriver path
    public static final String CHROMEDRIVER_DIRECTORY_PATH = "src/main/resources/drivers";

    private Constants()
    {
        throw new IllegalStateException("Constants class");
    }

}
