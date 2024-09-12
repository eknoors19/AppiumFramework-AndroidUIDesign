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

public class ListViewScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name+":id/List_ScrollQuick")
	public WebElement btnQuickScrolllBar;
	private By btnQuickScrolllBarBy = AppiumBy.id(pkg_name+":id/List_ScrollQuick");
	
	@AndroidFindBy(id = pkg_name+":id/List_SearchableListView")
	public WebElement btnSearchableListView;
	private By btnSearchableListViewBy = AppiumBy.id(pkg_name+":id/List_SearchableListView");
	
	public ListViewScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());

	}
	
	public IndexableScrollBarScreen clickQuickScrollBarBtn() {
		driver.findElement(btnQuickScrolllBarBy).click();
		log.info("Quick Scroll Bar Button is clicked");
		return new IndexableScrollBarScreen(driver);
	}
	
	public SearchableListViewScreen clickSearchableListViewBtn() {
		driver.findElement(btnSearchableListViewBy).click();
		log.info("Searchable List View Button is clicked");
		return new SearchableListViewScreen(driver);
	}

}
