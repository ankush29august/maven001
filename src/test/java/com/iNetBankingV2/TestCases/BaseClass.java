package com.iNetBankingV2.TestCases;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBankingV2.Utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	public String baseUrl=readConfig.getApplicationUrl();
	public String username=readConfig.getUserName();
	public String password=readConfig.getUserPassword();
	public String expectedUrl=readConfig.getExpectedUrl();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		 logger=Logger.getLogger("eBanking");
		 PropertyConfigurator.configure("log4j.properties");
		 
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+readConfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+readConfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/ScreenShots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	@AfterClass
	public void tearDown() {
    	 driver.quit();
     }
}
