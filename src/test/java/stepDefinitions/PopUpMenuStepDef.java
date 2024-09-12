package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Assert;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import screens.HomeScreen;
import screens.PopUpMenuScreen;
import screens.PopUpScreen;
import utility.CommonUtils;

public class PopUpMenuStepDef extends TestBase{
	
	public Properties dataProp;
	HomeScreen homescr;
	PopUpScreen popupscr;
	PopUpMenuScreen popupmenuscr;
	
	public Scenario scenario;

	@Before("@PopUpMenu")
	public void launchAndInstallApp(Scenario scenario) throws Exception {
		CommonUtils obj_enrol = new CommonUtils();
		if (loadPropertyFile.startsWith("Android")) {
			obj_enrol.loadAndroidConfProp(loadPropertyFile);
			obj_enrol.setAndroidCapabilities();
			
			dataProp = new Properties();
			File dataPropFile = new File(utility.Constants.DATACONFIG_FILE_PATH);
			
			try {
				FileInputStream dataFis = new FileInputStream(dataPropFile);
				dataProp.load(dataFis);
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
			
			driver = obj_enrol.getAndroidDriver();
			
			this.scenario = scenario;
			System.out.println("Executing the scenario" + scenario.getName());

		} else if (loadPropertyFile.startsWith("IOS")) {

		}

	}
	
	
	  @After("@PopUpMenu") 
	  public void afterScenario(Scenario scenario) 
	  {
		  driver.removeApp("com.boopathy.raja.tutorial.Splash"); 
		  driver.quit(); 
		}
	 
	
	@Given("app is installed for pop up")
	public void app_is_installed_for_pop_up() throws Exception {
		Thread.sleep(8000);
		homescr = new HomeScreen(driver);
	}
	 
	  
	@When("^user clicks on PopUp TextView Option$")
	public void user_clicks_on_pop_up_text_view_option() {
		homescr.clickHomeIcon();
		popupscr= homescr.selectPopUpMenuTextView("PopUp");
	}

	@When("^user clicks on PopUpMenu button$")
	public void user_clicks_on_pop_up_menu_button() {
	    popupmenuscr = popupscr.clickPopUpMenuBtn();
	}
	
	@When("^user clicks on ShowPopUpMenu button$")
	public void user_clicks_on_show_pop_up_menu_button() {
	    popupmenuscr.clickShowPopUpMenu();
	}
	
	@Then("^user performs Play Operation$")
	public void user_performs_play_operation() throws Exception {
		Thread.sleep(1000);
		popupmenuscr.clickShowPlay();
		System.out.println(popupmenuscr.getTextAfterClick());
		Assert.assertEquals(popupmenuscr.getTextAfterClick(),dataProp.getProperty("popUpMenuText"));
	}
}
