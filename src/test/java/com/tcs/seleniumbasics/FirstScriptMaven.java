package com.tcs.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScriptMaven {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("I am in Selenium now...");

		//## Driver Exe setting in path                                  //traditional way
//		System.setProperty("webdriver.chrome.driver",
//				"F:\\Newgen_Testing\\QA Automation_Selenium (Sharad Sir)\\Setup\\chromedriver-win64\\chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
		 
		
		
		
		// Selenium Manager                               //mostly use
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		driver.get("https://www.selenium.dev/downloads/");

		String expTitle = "Downloads | Selenium1";
		System.out.println("\nExpected Tile is: " + expTitle);

		String actTitle = driver.getTitle();
		System.out.println("Actual Tilte is: " + actTitle);

		if (expTitle.equals(actTitle)) {
			System.out.println("\nTest Passed - Title is correct");
		} else {
			System.out.println("\nTest failed- Expected and actual title mismatched..!");
		}

		String expUrl = "https://www.selenium.dev/downloads/";
		System.out.println("\nExpected Url is: " + expUrl);

		String actUrl = driver.getCurrentUrl();
		System.out.println("Actual Url is: " + actUrl);

		if (expUrl.equals(actUrl)) {
			System.out.println("\nTest Passed - Url is correct");
		} else {
			System.out.println("\nTest failed- Expected and actual Url mismatched..!");
		}

		// ## Timeout - Sync methods - Implicit, Explicit, Fluent Waits

		Thread.sleep(2000);
		driver.navigate().to("https://sites.google.com/chromium.org/driver/downloads");

		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();

		Thread.sleep(2000);
		driver.navigate().back();
		
//		Thread.sleep(2000);
//		driver.close();


	}

}
