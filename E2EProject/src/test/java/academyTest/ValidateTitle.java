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

public class ValidateTitle extends Base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException 
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		//driver.get("https://www.rahulshettyacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("Naviagated to Home page");
	}

	@Test
	public void validateAppTitle() throws IOException 
	{
		

		LandingPage lp = new LandingPage(driver);
		String actualTitle= lp.gettitle().getText();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Featured Cour123ses");
		log.info("Sucessfully validate message");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		
	}

	
}
