package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/* Driver script will manage the driver instance across the project, 
it will load the value from the properties file and initiate the application using the values that are provided in the properties file.*/

public class DriverScript {

	/* public driver reference which can be accessed across the project
	 * prop global variable to access properties class methods */
	
	public static WebDriver driver;
	static Properties prop;

	/* Constructor which is responsible for loading the properties file */
	public DriverScript() {

		try {
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load properties file ");
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Method called as initApplication which is responsible for taking the values
	 * from the properties file.
	 * this method is used to launch the browser and apply all teh wait settings and also navigate to the application.
	 */


	public void initApplication() {

		String browser = prop.getProperty("browser");
		if (browser.trim().equalsIgnoreCase("chrome")) {
			System.out.println("Browser in use " + browser);
			driver = new ChromeDriver();
		} else if (browser.trim().equalsIgnoreCase("firefox")) {
			System.out.println("Browser in use " + browser);
			driver = new FirefoxDriver();
		} else if (browser.trim().equalsIgnoreCase("edge")) {
			System.out.println("Browser in use " + browser);
			driver = new EdgeDriver();
		} else {
			System.out.println("Unsupported browser type! please check the config file!");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getAppurl();
	}
   /* getAppUrl method to read the values of a URL from the properties file, so we are calling this method inside the initApplication method */
	
	public static void getAppurl() {
		
	String url = prop.getProperty("url");
	driver.get(url);
		
	}
	
	/* Created another moethod to quit the driver instance */
	
	public static void quitDriver()
	{
		driver.quit();
	}

}
