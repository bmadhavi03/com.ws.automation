package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript
{
    @Test
	public void testLoginPageTitle() throws Exception
  {
	  initApplication();
	  HomePage homePage = new HomePage();
	  homePage.clickLoginLink();
	  LoginPage loginPage = new LoginPage();
	  String title = loginPage.getLoginPageTitle();
	  System.out.println("Page title "+title);
	  Assert.assertTrue(title.contains("Login"));
	  Thread.sleep(4000);
	  driver.quit();
	  
  }
    @Test
    public void testLoginFunction() throws Exception
    {
      initApplication();
  	  HomePage homePage = new HomePage();
  	  homePage.clickLoginLink();
  	  LoginPage loginPage = new LoginPage();
  	  loginPage.enterEmail("autotestuser1@email.com");
  	  loginPage.enterPassword("Pass@123");
  	  loginPage.clickLoginButton();
  	  Thread.sleep(4000);
  	  driver.quit();
    }
}
