package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript
{
 
    @Test
	public void testLoginPageTitle() 
  {
	  
	  homePage.clickLoginLink();
	  String title = loginPage.getLoginPageTitle();
	  System.out.println("Page title "+title);
	  Assert.assertTrue(title.contains("Login"));
	
	  
  }
    @Test
    public void testLoginFunction() 
    {
  	  homePage.clickLoginLink();
  	  loginPage.enterEmail("autotestuser1@email.com");
  	  loginPage.enterPassword("Pass@123");
  	  loginPage.clickLoginButton();
    }
}
