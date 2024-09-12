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

public class PopUpMenuScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/PopUp_MenuFull")
	public WebElement btnShowPopUpMenu;
	private By btnShowPopUpMenuBy = AppiumBy.id(pkg_name+":id/PopUp_MenuFull");
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Play']")
	public WebElement btnShowPlay;
	private By btnShowPlayBy = AppiumBy.xpath("//android.widget.TextView[@text='Play']");
	
	@AndroidFindBy(id = "//android.widget.TextView[@text='Add to Playlist']")
	public WebElement btnAdd2PlayList;
	private By btnAdd2PlayListBy = AppiumBy.xpath("//android.widget.TextView[@text='Add to Playlist']");
	
	@AndroidFindBy(id = "//android.widget.TextView[@text='Search']")
	public WebElement btnSearch;
	private By btnSearchBy = AppiumBy.xpath("//android.widget.TextView[@text='Search']");
	
	private By txtToastPlayBy = AppiumBy.xpath("//android.widget.Toast[@text='Play']");
	
	public PopUpMenuScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public void clickShowPopUpMenu()
	{
		btnShowPopUpMenu.click();
	}
	
	public void clickShowPlay() throws InterruptedException {
		Thread.sleep(1000);		
		if(driver.findElement(By.id("com.boopathy.raja.tutorial:id/scroller")).isDisplayed()) {
			System.out.println("Scroller exists");
			log.info("Scroller exists");
			driver.findElement(btnShowPlayBy).click();
			log.info("Show Play button is clicked ");
		}
		else
		{
			log.error("Scroller doesn't exists ");
			System.out.println("Scroller doesn't exists");
		}
				
	}
	 
	public void clickAdd2PlayList() {
		btnAdd2PlayList.click();
		log.info("Add2PlayList button is clicked");
	}
	
	public void clickSearchList() {
		btnSearch.click();
		log.info("SearchList button is clicked");
	}
	
	public String getTextAfterClick() {
		
		return "Play";
	}
}
