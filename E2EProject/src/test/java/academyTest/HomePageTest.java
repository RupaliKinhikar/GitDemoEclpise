package academyTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePageTest extends Base{
	
	public WebDriver driver;
		
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	  @BeforeTest public void initialization() throws IOException
	  { driver = initializeDriver(); 
	  //driver.get("https://www.rahulshettyacademy.com"); }
	  }
	 
	@Test(dataProvider="getData")
	public void baseNavigation(String uname,String Password) throws IOException, InterruptedException 
	{
		//this is imp step as Test is executed twice we have to invoke browser twice
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.getLogin();
		
		lop.getEmail().sendKeys(uname);
		lop.getPassword().sendKeys(Password);
		lop.getLoginButton().click();
		log.info("Login sucessed");
		
		ForgotPassword fp = lop.forgotPassword();
		fp.getEmail().sendKeys("abcd@gmail.com");
		fp.sendMeInstruction().click();;
	}
	
	 @AfterTest
	 public void tearDown()
	  { driver.close();
	  
	  }

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data =new Object[2][2];

		//row 1 means index starts with zero
		//rows for how many times you want to run test
		//column for how many values you have to pass to each test
		data[0][0]="Rupali@123";
		data[0][1]="Passwords";  

		data[1][0]="Rupali123@"; 
		data[1][1]="Pass";


		return data;

	}
	
	
	 
	 
}
