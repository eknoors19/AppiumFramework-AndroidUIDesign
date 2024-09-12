package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.Assert;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import screens.HomeScreen;
import screens.MagicalTextViewScreen;
import utility.CommonUtils;

public class MaicalTextViewStepDef extends TestBase{
	
	public Properties dataProp;
	HomeScreen homescr;
	MagicalTextViewScreen magicaltextscr;
	
	public Scenario scenario;

	@Before("@MagicalTextView")
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
	
	
	
	  @After("@MagicalTextView") 
	  public void afterScenario(Scenario scenario) 
	  {
		  driver.removeApp("com.boopathy.raja.tutorial.Splash"); 
		  driver.quit();
	  }
	 
	
	@Given("app is installed for Magical Text")
	public void app_is_installed_for_magical_text() throws Exception {
		Thread.sleep(10000);
		homescr = new HomeScreen(driver);
	}
	
	@When("^user clicks on Magical TextView Option$")
	public void user_clicks_on_magical_text_view_option() {
		
		homescr.clickHomeIcon();
		magicaltextscr= homescr.selectMagicalTextView("Magical TextView");
	}

	@When("^user fetches the Magical TextView text$")
	public void user_fetches_the_magical_text_view_text() {
		String actMagicalTxt= magicaltextscr.getMagicalViewText();
		System.out.println("Magical Text: "+ actMagicalTxt);
		Assert.assertEquals(actMagicalTxt, dataProp.getProperty("magicalTextView"), "Magical Text View is not matching");
		
	}
	
}
