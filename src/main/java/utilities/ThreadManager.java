package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;

public class ThreadManager {
    private static ThreadLocal<AndroidDriver<WebElement>> androidDriver = new ThreadLocal<>();
    private static ThreadLocal<String> deviceUdid = new ThreadLocal<>();
    private static ThreadLocal<Integer> appiumPort = new ThreadLocal<>();
    private static ThreadLocal<Integer> systemPort = new ThreadLocal<>();
    private static ThreadLocal<AppiumServiceBuilder> appiumServiceBuilder = new ThreadLocal<AppiumServiceBuilder>();
    private static ThreadLocal<AppiumDriverLocalService> appiumLocalService = new ThreadLocal<AppiumDriverLocalService>();

    /**
     * Set androidDriver
     * @param driver
     */
    public static synchronized  void setDriver(AppiumDriver<WebElement> driver) {
        androidDriver.set((AndroidDriver<WebElement>)driver);
    }

    /**
     * Get androidDriver
     * @return
     */
    public static synchronized AppiumDriver<WebElement> getDriver() {
        return androidDriver.get();
    }

    /**
     * Set deviceUdid
     * @param udid
     */
    public static synchronized void setDeviceUdid(String udid) {
        deviceUdid.set(udid);
    }

    /**
     * Get deviceUdid
     * @return deviceUdid
     */
    public static synchronized String getDeviceUdid() {
        return (String) deviceUdid.get();
    }

    /**
     * Set appiumPort
     * @param portValue
     */
    public static synchronized void setAppiumPort(String portValue) {
        appiumPort.set(Integer.parseInt(portValue));
    }

    /**
     * Get appiumPort
     * @return appiumPort
     */
    public static synchronized int getAppiumPort() {
        return (int) appiumPort.get();
    }

    /**
     * Set systemPort
     * @param portValue
     */
    public static synchronized void setSystemPort(String portValue) {
        systemPort.set(Integer.parseInt(portValue));
    }

    /**
     * Get systemPort
     * @return systemPort
     */
    public static synchronized int getSystemPort() {
        return (int) systemPort.get();
    }

    /**
     * Set appiumServiceBuilder
     * @param service
     */
    public static synchronized void setAppiumServiceBuilder(AppiumServiceBuilder service) {
        appiumServiceBuilder.set(service);
    }

    /**
     * Get appiumServiceBuilder
     * @return appiumServiceBuilder
     */
    public synchronized static AppiumServiceBuilder getAppiumServiceBuilder() {
        return appiumServiceBuilder.get();
    }

    /**
     * Set appiumLocalService
     * @param service
     */
    public static synchronized void setAppiumLocalService(AppiumDriverLocalService service) {
        appiumLocalService.set(service);
    }

    /**
     * Get appiumLocalService
     * @return appiumLocalService
     */
    public static synchronized AppiumDriverLocalService getAppiumLocalService() {
        return appiumLocalService.get();
    }

    /**
     * Set deviceUdid,appiumPort,systemPort
     * @param deviceUdid device udid
     * @param appiumPort appium port
     * @param systemPort system port
     */
    public static synchronized void setAllForAndroid(String deviceUdid, String appiumPort, String systemPort) {
        setDeviceUdid(deviceUdid);
        setAppiumPort(appiumPort);
        setSystemPort(systemPort);
    }
}
