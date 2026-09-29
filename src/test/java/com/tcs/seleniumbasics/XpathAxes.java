package com.tcs.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Xpath Demo..!!");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		Thread.sleep(2000);
		
		WebElement fName = driver.findElement(By.xpath("//div[@class='container']/child::input[1]"));
		fName.sendKeys("Virat");
		Thread.sleep(2000);
		
		WebElement lName = driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input[1]"));
		lName.sendKeys("Kohali");
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//div[@class='buttons']/preceding-sibling::input[2]"));
		email.sendKeys("viratkohali@gmail.com");
		Thread.sleep(2000);
		
		WebElement pw = driver.findElement(By.xpath("//form/descendant::input[4]"));
		pw.sendKeys("Virat@1234");
		Thread.sleep(2000);
		
		WebElement rpw = driver.findElement(By.xpath("//form/descendant::input[5]"));
		rpw.sendKeys("Virat@123");
		Thread.sleep(3000);
		
		WebElement register = driver.findElement(By.xpath("//div[@class='buttons']/descendant::button[1]"));
		Thread.sleep(3000);
		register.click();
		Thread.sleep(3000);
		
		WebElement check = driver.findElement(By.xpath("//*[@id=\"contactList\"]/tbody/tr[2]/td[1]/input"));
		check.click();
		Thread.sleep(3000);
		
		WebElement clk = driver.findElement(By.xpath("//table[@id='contactList']/descendant::a[1]"));
		clk.click();
		
		
		

	}

}
