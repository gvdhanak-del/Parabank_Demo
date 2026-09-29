package com.tcs.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasicTest {
	
	WebDriver driver;
	
	@Test
	public void verifyTitle() {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		String actTitle = driver.getTitle();
		System.out.println("Actual Title: " + actTitle);
		
		Assert.assertEquals(actTitle, "Google");
		
		System.out.println("My Title Test Passed");
	}

}
