package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class HomePage extends DriverScript {
	
// *********************** Page Elements *********************//
	
	@FindBy(linkText = "Log in") WebElement loginLink;
	
// *********************** Page Initialization *********************//
	/*To map between local variables and the constructor we use 'this' keyword and in POM there is a class called PageFactory where you will initialize the elements(locators) to the driver*/
	
	public HomePage ()
	{
		PageFactory.initElements(driver, this);
	}
	
// *********************** Page Actions/Methods *********************//
/* For each of the element  we have to create seperate action/method which performs required action of this element*/
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	      
	
	public void clickLoginLink()
	{
		loginLink.click();
	}
	                    
	
}
