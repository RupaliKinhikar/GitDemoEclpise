package academyTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

import resources.Base;

public class NavigationBarValidation extends Base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialization() throws IOException
	{
		driver = initializeDriver();
		//driver.get("https://www.rahulshettyacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("NavigationBarValidation url is reached");
	}
	
	
	@Test
	public void baseNavigation() 
	{


		LandingPage lp = new LandingPage(driver);
		Boolean navi = lp.getNavigation().isDisplayed();
		System.out.println(navi);
		Assert.assertTrue(navi, "It is not present ");
		log.info("Navigation bar is present");

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}
	


}
