package screens;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class HomeScreen extends ScreenBase{
	
	public static Properties prop = new Properties();
	private Logger log;

	public static final String pkg_name = Constants.PKG_NAME;

	@AndroidFindBy(id = pkg_name + ":id/et_name")
	public WebElement full_Name;

	@AndroidFindBy(id = pkg_name + ":id/et_number")
	public WebElement mobile_Number;
	
	@AndroidFindBy(id = "android:id/home")
	public WebElement selectHomeIcon;
	
	public HomeScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());

	}
	
	public void clickHomeIcon() {
		selectHomeIcon.click();
		log.info("Home Icon is clicked");
	}
	
	public DragnDropScreen selectDragnDropTextView(String option) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + option + "\"]")).click();
		log.info("Drop Text View is clicked");
		return new DragnDropScreen(driver);
		
	}
	
	public PopUpScreen selectPopUpMenuTextView(String option) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + option + "\"]")).click();
		log.info("Pop Up Menu is clicked");
		return new PopUpScreen(driver);
			
	}
	
	public MagicalTextViewScreen selectMagicalTextView(String option) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + option + "\"]")).click();
		log.info("Magical Text View is clicked");
		return new MagicalTextViewScreen(driver);
		
	}
	
	public ListViewScreen selectListTextView(String option) {
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + option + "\"]")).click();
		log.info("Select Text View is clicked");
		return new ListViewScreen(driver);
		
	}
	
}
