package com.qait.gateway.deploytool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qait.gateway.Utils.UiUtils;

public class GatewayCourseCreationAndActivityImport_D2L extends UiUtils  {

	public static void CC_1stOption(String name, WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='selectedOption' and @value='CREATE_NEW']")).click();
		driver.findElement(By.xpath("//input[@id='courseName']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@id='startDateAsString']")).sendKeys(new UiUtils().dt_CourseDate());
		driver.findElement(By.xpath("//input[@id='endDateAsString']")).sendKeys(new UiUtils().dt_CourseDate_Max());
		Select region=new Select(driver.findElement(By.xpath("//select[@id='timezoneId']")));
		region.selectByIndex(8);
		driver.findElement(By.xpath("//span[@id='continuebutton' and @class='gatewaybutton']")).click();
		driver.findElement(By.xpath("//span[@id='continuebutton' and @class='gatewaybutton']")).click();
		driver.findElement(By.xpath("//li[@class='d2l-tool-areas-item']//a[text()='Content']")).click();
		driver.findElement(By.xpath("//div[text()='KD']"));
		driver.findElement(By.xpath("//a[contains(@title,'"+name+"')]")).click();
		try{
			Thread.sleep(10 * 1000);
			}catch(InterruptedException ie){}
		String oldWindow= driver.getWindowHandle();
		
		new UiUtils().switchToNewWindow(driver);
	}
	
	
}
