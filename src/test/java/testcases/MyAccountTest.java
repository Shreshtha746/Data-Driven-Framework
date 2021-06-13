package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;

public class MyAccountTest extends TestBase {
	
	@Test(priority=1)
	public void myaccount() throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty("myaccBtn"))).click(); //Clicks MyAccount tab
		Thread.sleep(3000);
	}
	
	@Test(priority=0)
	public void verifyTitle()
	{
		String actualTitle = driver.getTitle();
		//System.out.println(actualTitle);
		String expectedTitle = "Automation Practice Site";
		Assert.assertEquals(expectedTitle, actualTitle); //checks whether the title is expected title or not
		
	}
	
	@Test(priority=2)
	public void login()
	{
		//logging via username and password
		//giving it as priority 2 because this method should work only after MyAccount has been clicked
		driver.findElement(By.xpath(OR.getProperty("emaillogin"))).sendKeys("tt7908810@gmail.com");
		driver.findElement(By.xpath(OR.getProperty("passwordlogin"))).sendKeys("test@2409sel");
		driver.findElement(By.xpath(OR.getProperty("loginBtn"))).click();
	}
	
	@Test(priority=3)
	public void addToCart() throws InterruptedException
	{
		//keeping it as priority 3 as this will work only after the user has logged in
		//after logging in, it clicks on Shop tab, then android tab on the left side, followed by other buttons mentioned
		driver.findElement(By.xpath(OR.getProperty("shopBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("androidBtn"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty("androidQuickStartGuide"))).click();
		driver.findElement(By.xpath(OR.getProperty("addToBasket"))).click();
		driver.findElement(By.xpath(OR.getProperty("viewBasketBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("myAccBtn"))).click();
		
	}
	
	@Test(priority=4)
	public void logout()
	{
		//logs out once other methods are executed
		driver.findElement(By.xpath(OR.getProperty("logoutBtn"))).click();
	}


}
