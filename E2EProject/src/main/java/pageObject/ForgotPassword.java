package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	By email = By.cssSelector("input[id='user_email']");
	By sendmeInstruction = By.cssSelector("input[type='submit']");
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	

	public WebElement sendMeInstruction()
	{
		return driver.findElement(sendmeInstruction);
	}

	
}
