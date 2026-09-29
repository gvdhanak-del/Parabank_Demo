package com.tcs.testng;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersClass.class)
public class BasicTestNg {
	
	WebDriver driver;
	@BeforeMethod 
	public void beforeMethod() {
		System.out.println("In before Method");

	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("In after Method");

	}
	
	@Test (groups = {"abc"})
	public void VerifyTitle() {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		String actTitle = driver.getTitle();
		System.out.println("Actual Title: " + actTitle);
		
		Assert.assertEquals(actTitle, "Google");
		System.out.println("Title Test Passed");	
	}
	
	@Test(dataProviderClass = DemoTest.class, dataProvider = "dp2")
	public void dataSupply(String s) {
		System.out.println("in dataSupply() mthod");
		System.out.println("Test Data: " + s);
	}
	
	 @Test(groups= {"xyz"})
		public void X() {
			System.out.println(" I am in Test X() Method");
			Assert.assertFalse(false);
		}
	
	 @Test(groups= {"xyz"})
		public void Y() {
			System.out.println(" I am in Test Y() Method");
			Assert.assertFalse(true);
		}

}
