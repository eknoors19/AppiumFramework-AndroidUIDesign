package stepDefinitions;

import java.util.Objects;
import org.testng.Assert;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import screens.DragnDropScreen;
import screens.HomeScreen;
import screens.SimpleDragnDropScreen;
import utility.CommonUtils;

public class DragnDropStepDef extends TestBase{

	HomeScreen homescr;
	DragnDropScreen dragndropscr;
	SimpleDragnDropScreen simpdragdropscr;
	
	
	public Scenario scenario;

	@Before("@DragDrop")
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
	
	
	  @After("@DragDrop") 
	  public void afterScenario(Scenario scenario) 
	  {
		  driver.removeApp("com.boopathy.raja.tutorial.Splash"); 
		  driver.quit(); 
	  }
	 
	
	
	@Given("^app is installed$")
	public void app_is_installed() throws Exception {
		//logger.info("************************Home screen initiated****************************");
		
		Thread.sleep(10000);
		if(!Objects.isNull(driver))
		{
			System.out.println("object is not null, setting it again");
			homescr = new HomeScreen(driver);
			if(!Objects.isNull(homescr)) {
				System.out.println("Home screen object: "+ homescr);
			}
		}
		System.out.println("Setting Home Screen Object");
	}
	
	@When("^user clicks on DragAndDrop TextView Option$")
	public void user_clicks_on_drag_and_drop_text_view_option() {
	   homescr.clickHomeIcon();
	   dragndropscr= homescr.selectDragnDropTextView("Drag & Drop");
	}

	@When("^user clicks on Simple DragAndDrop button$")
	public void user_clicks_on_simple_drag_and_drop_button() {
		simpdragdropscr= dragndropscr.clickSimpleDragDropBtn();
	}

	@When("^user performs DragAndDrop Operation$")
	public void user_performs_drag_and_drop_operation() throws InterruptedException {
		try {
			Boolean dragndrop= simpdragdropscr.moveDragToDropOperation();
			System.out.println("User performs drag and drop operation");
			Assert.assertTrue(dragndrop, "Drag and Drop is not performed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
