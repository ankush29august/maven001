 package com.iNetBankingV2.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configration\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserName() {
		String uName=pro.getProperty("username");
		return uName;
	}
	
	public String getUserPassword() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	
	public String getExpectedUrl() {
		return pro.getProperty("expectedUrl");
	}
	public String getChromePath() {
		String cPath=pro.getProperty("chromepath");
		return cPath;
	}
	
	public String getFirefoxPath() {
		String fPath=pro.getProperty("firefoxpath");
		return fPath;
	}
	
	public String getMicrosoftWebDriverPath() {
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	
}
