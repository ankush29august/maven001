package com.iNetBankingV2.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBankingV2.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	
		@Test
	public void loginTest() {
		
		logger.info("Url is Open");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("entered username");
		lp.setUserPassword(password);
		logger.info("entered password");
		lp.clickSubmit();
		logger.info("clicked login");
		
		if(driver.getCurrentUrl().equals(expectedUrl)) {
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else {
			try {
				captureScreen(driver, "loginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}
		
	}

}
