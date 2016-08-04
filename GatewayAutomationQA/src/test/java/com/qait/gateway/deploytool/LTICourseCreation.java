package com.qait.gateway.deploytool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qait.gateway.Utils.UiUtils;

public class LTICourseCreation extends UiUtils  {
	
	public String createMindTapCourse(WebDriver driver) {
		driver.findElement(By.className("menuText")).click();
		driver.findElement(By.xpath("//a[@id='btnCreateMindLinks']")).click();
		driver.findElement(By.xpath("//select[@id='titleisbn10']")).click();
		driver.findElement(By.xpath("//option[@value='0-495-91623-4']")).click();
		driver.findElement(By.xpath("//button[@id='courseWizardNext']")).click();
		driver.findElement(By.xpath("(.//*[@id='iacIsbn'])[2]")).click();	
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Next']")).click();
		driver.findElement(By.xpath("//input[@id='assignmentMode']")).click();
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Next']")).click();
		try{
		Thread.sleep(3 * 1000);
		}catch(InterruptedException ie){}
		String cName="QA Test PNv2 "+dt_TimeStamp(); // Integration of the course name with current Time Stamp
		driver.findElement(By.xpath(".//*[@id='courseName' and @class = 'contentTextBoxNormal contentTextBoxWidth']")).sendKeys(cName);	// Course name input
		driver.findElement(By.xpath("//input[@id='displayName' and @class='contentTextBoxNormal contentTextBoxWidth']")).sendKeys(cName);
		driver.findElement(By.xpath("//input[@id='version']")).sendKeys("1292");
		driver.findElement(By.xpath("*//button[@type='button']//span[text()='Next']")).click();
		driver.findElement(By.xpath("//button[@type='button']//span[text()='Done']")).click(); // Course created
		try{
		Thread.sleep(10 * 1000);
		}catch(InterruptedException ie)	{}
		driver.findElement(By.xpath("//div[@id='courseWizardPage4']/preceding-sibling::div/a")).click();
		try{
		Thread.sleep(3 * 1000);
		}catch(InterruptedException ie)	{}
		driver.findElement(By.linkText(cName)).click();
		return cName;
	}

}
