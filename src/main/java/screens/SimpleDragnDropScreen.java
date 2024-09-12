package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import utility.Constants;

public class SimpleDragnDropScreen extends ScreenBase
	{
	
	public static final String pkg_name = Constants.PKG_NAME;;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drag1")
	public WebElement Drag1;
	private By Drag1By = AppiumBy.id(pkg_name+":id/DragDrop_Drag1");
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drop1")
	public WebElement Drop1;
	private By Drop1By = AppiumBy.id(pkg_name+":id/DragDrop_Drop1");
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drag2")
	public WebElement Drag2;
	private By Drag2By = AppiumBy.id(pkg_name+":id/DragDrop_Drag2");
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drop1")
	public WebElement Drop2;
	private By Drop2By = AppiumBy.id(pkg_name+":id/DragDrop_Drop2");
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drag3")
	public WebElement Drag3;
	private By Drag3By = AppiumBy.id(pkg_name+":id/DragDrop_Drag3");
	
	@AndroidFindBy(id = pkg_name+":id/DragDrop_Drop1")
	public WebElement Drop3;
	private By Drop3By = AppiumBy.id(pkg_name+":id/DragDrop_Drop3");
	
	public SimpleDragnDropScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public Boolean moveDragToDropOperation() throws Exception {
		Thread.sleep(2000);
		Boolean moveDragToDropOperation= false;
		if(driver.findElement(Drag1By).isDisplayed())
		{
			if(driver.findElement(Drop1By).isDisplayed())
			{
				try {
					TouchAction action =new TouchAction((PerformsTouchActions) driver);
					//performing the long press
					action.longPress(new LongPressOptions().withElement(new ElementOption().withElement(Drag1))).perform();
					//performing the move to touch operation
					action.moveTo(new ElementOption().withElement(Drop1)).perform().release();
					log.info("Drag Operation is performed");
					moveDragToDropOperation= true;
				}catch(Exception e)
				{
					log.error("Drag Operatin failed with error: "+e);
				}
			}
		}
		return moveDragToDropOperation;
	}
}	
