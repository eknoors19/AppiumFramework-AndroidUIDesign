package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;
import utility.TestUtil;

public class SearchableListViewScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/listview_search")
	public WebElement textSearchCountry;
	private By textSearchCountryBy = AppiumBy.id(pkg_name+":id/listview_search");
	
	
	@AndroidFindBy(id = pkg_name+":id/listview_seacrh_text")
	public WebElement textSearchedCountry;
	private By textSearchedCountryBy = AppiumBy.id(pkg_name+":id/listview_seacrh_text");
		
	public SearchableListViewScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	public Boolean searchForCountry(String countryText) throws Exception
	{
		Boolean searchForCountry= false;
		log.info("USer is searching for CountryName "+countryText);
		textSearchCountry.sendKeys(countryText);
		if(searchForCountryList(countryText))
			searchForCountry=true;
			
		return searchForCountry;
	}
	
	public Boolean searchForCountryList(String countryName) throws InterruptedException
	{
		Boolean searchForCountryList= false;
		if((driver.findElement(textSearchedCountryBy)).getText().equalsIgnoreCase(countryName))
		{
			searchForCountryList= true;
			log.info("Country searched is found");
		}
		driver.navigate().back();
		return searchForCountryList;
		
	}
	
	
}
