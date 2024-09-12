package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class PopUpScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/PopUp_Menu")
	public WebElement btnPopUpMenu;
	private By btnPopUpMenuBy = AppiumBy.id(pkg_name+":id/PopUp_Menu");
	
	public PopUpScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public PopUpMenuScreen clickPopUpMenuBtn() {
		
		driver.findElement(btnPopUpMenuBy).click();
		log.info("PopUp Menu button is clicked");
		return new PopUpMenuScreen(driver);
	}
	
	

}
