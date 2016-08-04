package com.qait.gateway.deploytool;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qait.gateway.Utils.UiUtils;

public class DeploymentToolLogin extends UiUtils {

	public void ValidLogin(WebDriver driver) throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES); //waiting for elements of the page to load
	    driver.manage().window().maximize();    //Maximizing the window
	   
		driver.get("https://cgatewayqa.cengage.com/deploytool/login/login.html"); //Launching the DT URL
		driver.findElement(By.id("about")).click();
		
		String Git= driver.findElement(By.id("footerGitHash")).getText(); // Fetching the 'Git Hash' of the Application
		if(Git.isEmpty()) 	// Waiting for the element value to be present
		{
			try
			{
			Thread.sleep(3 * 1000);
			}catch(InterruptedException ie)
			{
			}
		}
		Git= driver.findElement(By.id("footerGitHash")).getText();
		String GateVersion= driver.findElement(By.id("footerAppVersion")).getText(); //Fetching the Gateway Version
		String DTVersion= driver.findElement(By.id("footerBuildVersion")).getText(); // Fetching the Deployment Tool version
		
		driver.findElement(By.id("userId")).sendKeys("kunaaldwivedi@qainfotech.net");
		driver.findElement(By.id("password")).sendKeys("Password1");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES); //waiting for elements to load

		driver.findElement(By.id("btnLogin")).click(); // Logging into the application
		
		System.out.println("DT Git Hash = "+Git);	// Printing the basic details of build
		System.out.println("Gateway Build version ="+GateVersion);
		System.out.println("Deployment Tool build version=" +DTVersion);
		
	}
	
	
	
	
}

