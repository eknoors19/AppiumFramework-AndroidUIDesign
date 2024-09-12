package screens;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class DragnDropScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/Drag_and_Drop")
	public WebElement btnDragDrop;
	
	private By btnDragDropBy = AppiumBy.id(pkg_name+":id/Drag_and_Drop");
	
	@AndroidFindBy(id = pkg_name+":id/Drag_and_Drop_Simple")
	public WebElement btnSimpleDragDrop;
	
	private By btnSimpleDragDropBy = AppiumBy.id(pkg_name + ":id/Drag_and_Drop_Simple");
	
	/*
	 * Initialization of the class with page factory
	 */
	
	public DragnDropScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public void clickDragDropBtn() {
		btnDragDrop.click();
		log.info("Drag and Drop Button is clicked");
	}
	
	public SimpleDragnDropScreen clickSimpleDragDropBtn() {
		btnSimpleDragDrop.click();
		log.info("Simple Drag and Drop Button is clicked");
		return new SimpleDragnDropScreen(driver);
	}
	
}
