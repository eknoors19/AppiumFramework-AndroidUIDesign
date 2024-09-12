package driver;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import screens.HomeScreen;

public class AppFactory {
	public static AndroidDriver driver;

    private static void android_launchApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("8.0")
                .setAppPackage("com.boopathy.raja.tutorial")
                .setAppActivity("com.boopathy.raja.tutorial.Splash");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }
 
    public static HomeScreen launchApp() throws Exception {
        System.out.println("entering into launchapp");
        
        android_launchApp();
        System.out.println("Android launched...");
        Thread.sleep(12000);
         return new HomeScreen(driver);  
    }

}
