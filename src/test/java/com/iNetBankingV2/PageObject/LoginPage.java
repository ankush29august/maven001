package com.iNetBankingV2.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	
	
	public LoginPage(WebDriver rDriver) {
		 lDriver=rDriver;
		 PageFactory.initElements(rDriver, this);
	}
	 
	

	@FindBy(id="txtUsername")
	 @CacheLookup
	 WebElement txtUsername;
	 
	 @FindBy(id="txtPassword")
	 @CacheLookup
	 WebElement txtPassword;
	 
	 @FindBy(id="btnLogin")
	 @CacheLookup
	 WebElement btnLogin;
	 
	 @FindBy(id="welcome")
	 WebElement Admin;
	 
	 @FindBy(xpath="//*[@id=\"welcome-menu\"]/ul/li[2]/a")
	 WebElement logout;
	 
	 @FindBy(id="spanMessage")
	 WebElement invalid;
	 
	 public void setUserName(String uName) {
		 txtUsername.sendKeys(uName);
		 }
	 
	 public void setUserPassword(String pwd) {
		 txtPassword.sendKeys(pwd);
		 }
	 
	 public void clickSubmit() {
		 btnLogin.submit();
		 
	 }
	 
	 public void clickLogout() {
		 Admin.click();
		 logout.click();
	 }
	 
	 public boolean validate() {
		 return invalid.getText().equals("Invalid credentials");
		 
	 }

}
