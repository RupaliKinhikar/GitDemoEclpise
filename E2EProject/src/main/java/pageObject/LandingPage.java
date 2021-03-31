package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By signin = By.cssSelector("a[href*='sign_in']");
	By title= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigate =By.xpath("//nav[@class='main-menu']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public LoginPage getLogin()
	{
		//This page is navigate to Login Page so we are defining every thing here n returning object of Loginpage
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigation()
	{
		return driver.findElement(navigate);
	}

}
