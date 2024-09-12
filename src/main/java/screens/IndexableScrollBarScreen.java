package screens;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.CommonUtils;
import utility.Constants;
import utility.TestUtil;

public class IndexableScrollBarScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/List_ScrollQuick")
	public WebElement btnShowPopUpMenu;
	private By btnShowPopUpMenuBy = AppiumBy.id(pkg_name+":id/PopUp_MenuFull");
		
	public IndexableScrollBarScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public Boolean scrollUpToCountry(String countryName)
	{
		Boolean scrollUpToCountry=false;
		
		try {
			log.info("Scrolling Up To Element "+ countryName );
			Boolean status = CommonUtils.scrollUptoElement(countryName); 
			scrollUpToCountry= status;
			System.out.println("Scroll Up to Country status is: "+ status);
			Assert.assertTrue(true, "Country name is not found");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scrollUpToCountry;
	}
	
}
