package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By loginButton = By.cssSelector("input[value='Log In']");
	By forgotPassword= By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public ForgotPassword forgotPassword() throws InterruptedException
	{
		
		driver.findElement(forgotPassword).click();
		Thread.sleep(5000);
		return new ForgotPassword(driver);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
}
