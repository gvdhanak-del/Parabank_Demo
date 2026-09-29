package com.tcs.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Locator Demo..!!");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys("hello Google");
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
		Thread.sleep(3000);
		
		WebElement textInput = driver.findElement(By.id("my-text-id"));
		textInput.sendKeys("QA Automation Selenium");
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.name("my-password"));
		password.sendKeys("Password@123");
		Thread.sleep(3000);
		
		WebElement txtArea = driver.findElement(By.name("my-textarea"));
		txtArea.sendKeys("we are in locater assignment..!!");
		Thread.sleep(3000);
		
		WebElement dropDownSelect = driver.findElement(By.name("my-select"));
		Select select = new Select(dropDownSelect);
		select.selectByVisibleText("One");
		
		
		
		
		
		
		
		

	}

}
