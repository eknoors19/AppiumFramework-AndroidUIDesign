package stepDefinitions;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.HomeScreen;
import screens.IndexableScrollBarScreen;
import screens.ListViewScreen;
import screens.SearchableListViewScreen;
import utility.CommonUtils;

public class QuickScrollBarStepDef extends TestBase{
	
	HomeScreen homescr;
	ListViewScreen listviewscr;
	IndexableScrollBarScreen indexscrollbarscr;
	SearchableListViewScreen searchlistviewscr;
	
	public Scenario scenario;

	@Before("@QuickScrollBar")
	public void launchAndInstallApp(Scenario scenario) throws Exception {
		CommonUtils obj_enrol = new CommonUtils();
		if (loadPropertyFile.startsWith("Android")) {
			obj_enrol.loadAndroidConfProp(loadPropertyFile);
			obj_enrol.setAndroidCapabilities();
			driver = obj_enrol.getAndroidDriver();
			this.scenario = scenario;
			System.out.println("Executing the scenario" + scenario.getName());

		} else if (loadPropertyFile.startsWith("IOS")) {
		}

	}
	
	@After("@QuickScrollBar")
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
	        System.out.println("Scenario is Failed Taking ScreenShot...!!!");
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", scenario.getName());
	       
	    }
		driver.removeApp("com.boopathy.raja.tutorial.Splash");
		driver.quit();
	}
	
	@Given("app is installed for scroll list")
	public void app_is_installed_for_scroll_list() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(8000);
		homescr = new HomeScreen(driver);
	}
	 
	@When("^user clicks on ListView TextView Option$")
	public void user_clicks_on_list_view_text_view_option() {
		homescr.clickHomeIcon();
		listviewscr= homescr.selectListTextView("ListView");
	}

	@When("^user clicks on quick scrollbar button$")
	public void user_clicks_on_quick_scrollbar_button() {
		indexscrollbarscr= listviewscr.clickQuickScrollBarBtn();
	   
	}

	@When("user performs scroll Operation for country \"([^\"]*)\"$")
	public void user_performs_scroll_operation_for_country(String country) {
		Boolean scroolStatus = indexscrollbarscr.scrollUpToCountry(country);
		Assert.assertTrue(scroolStatus, "scroll up to country: "+ country +" is not found");
	}
	
	@When("^user clicks on searchable listview button$")
	public void user_clicks_on_searchable_listview_button() {
		searchlistviewscr= listviewscr.clickSearchableListViewBtn();
	}
	
	@When("^user performs search Operation in list for \"([^\"]*)\"$")
	public void user_performs_search_operation_in_list_for(String countryName) throws Exception {
		Boolean searchOperation = searchlistviewscr.searchForCountry(countryName);
		Assert.assertTrue(searchOperation, "search for country: "+ countryName +" is not found");
	}

	
}
