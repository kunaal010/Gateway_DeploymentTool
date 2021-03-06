package com.qait.gateway.deploytool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qait.gateway.Utils.UiUtils;

public class LMSLaunchAndLogin_D2L extends UiUtils  {

	public WebDriver LMSLaunch_Login(WebDriver driver){
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();	//Clearing the cookies
		driver.get("http://cengage.brightspacetrial.com/");	// LMS URL
		driver.findElement(By.xpath("//input[@id='username' and @class='form-control']")).sendKeys("Cengage.f1");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Cengage123");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
}
