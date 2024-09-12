package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase {
	
	public static AppiumDriver driver;
	public WebDriverWait wait;
	
		public ScreenBase(AppiumDriver driver) {
			this.driver = driver;
		}
		
		public static void hideKeyboard() {
			((HidesKeyboard) driver).hideKeyboard();
		}
		
		protected void waitForVisibilityOf(String locatorID) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorID)));
		}

}
