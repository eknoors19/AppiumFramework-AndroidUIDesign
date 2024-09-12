package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import base.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class MagicalTextViewScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Play On!']")
	public WebElement txtMagicalView;
	private By txtMagicalViewBy = AppiumBy.xpath("//android.widget.TextView[@text='Play On!']");
	
	public MagicalTextViewScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public String getMagicalViewText() {
		//btnPopUpMenu.click();
		return driver.findElement(txtMagicalViewBy).getText();
		
	}
	

}
