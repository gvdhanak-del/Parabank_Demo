package com.tcs.testng;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoTest {
  @Test  (enabled = true, groups = {"abc"})
  public void af1() {
	  System.out.println("I am in the af1() test method..");
	  Assert.assertTrue(true);
  }
  
  @Test  (dependsOnMethods = {"s"}, groups= {"abc1","abc"})
  public void af() {
	  System.out.println("I am in the af() test method..");
	  Assert.assertTrue(true);
  }
  
  @Test (priority = 1234, dependsOnGroups = "abc")
	public void S() {
		System.out.println(" I am in Test S() Method");
		Assert.assertTrue(true);

	}

  @Test(priority = -40, groups= {"abc"})
	public void s() {
		System.out.println(" I am in Test s() Method");
		Assert.assertFalse(false);
	}
  
  @Test(priority = 5484, dataProvider = "dp1", groups = {"abc"})
	public void dp(Integer i, String s) {
		System.out.println(" I am in Test dp() Method");
		System.out.println("Test Data Interger: "+ i);
		System.out.println("Test Data String: "+ s);
		
	}
  
  @DataProvider
  public Object dp1() {
	  return new Object[][] {new Object[] {1,"a"}, new Object[] {2,"b"}, new Object[] {3,"c"} };
  }
  
  @Test(dataProvider = "dp2")
  public void data(String s) {
	  System.out.println("In data() method..");
	  System.out.println("Test Data: "+ s);
  }
  
  @Test(groups = {"abc"})
  @Parameters({"userid", "pass", "fname"})
  public void loginTest(String user, String pass, String fname) {
	  System.out.println("I am in loginTest() method");
	  System.out.println("Login Credentials: "+ user + ":" + pass);
	  System.out.println("I am in LoginTest and First Name is: " + fname);
	  
	  Assert.assertEquals(user, "Dhanak");
	  Assert.assertEquals(pass, "Dhanak@123");
	  
  }
  
  
  
  @DataProvider
  public Object dp2() {
	  return new Object[] {"string"};
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(" I am in Before Method - will be execcuted before each Test method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(" I am in After Method - will be execcuted after each Test method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(" I am in Before Class - will be executed Before each Class ");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(" I am in After Class - will be executed after each Class ");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(" I am in Before Test - will be execcuted Before any Test Journeys execution");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(" I am in After Test - will be execcuted after All Test Journeys execution");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println(" I am in before suite - will be execcuted before suite execution");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println(" I am in after suite - will be execcuted after suite execution");
  }

}
