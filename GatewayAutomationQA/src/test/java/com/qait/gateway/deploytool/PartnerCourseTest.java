package com.qait.gateway.deploytool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.qait.gateway.Utils.UiUtils;

public class PartnerCourseTest extends UiUtils  {
	
	WebElement deliverDropDown;
	WebElement selectInst;
	String DTWinHandle;

	public void courseTest(WebDriver driver){
		Actions actObj= new Actions(driver);
		deliverDropDown= driver.findElement(By.xpath("//label[@class='menuText' and text()='DELIVER COURSES']"));
		actObj.moveToElement(deliverDropDown).build().perform();
		driver.findElement(By.xpath("//label[@class='menuText' and text()='Test Course']")).click();
		driver.findElement(By.xpath("//button[@originalbuttontext='OK']//span[text()='OK']")).click();
		
		String Institution="23rd Nov OREGON Test Inst D2L 10.5 Partner"; //Selecting Institution
		driver.findElement(By.xpath("//input[@id='name' and @class='search_init']")).sendKeys(Institution); 
		driver.findElement(By.xpath("//div[@id='submitInstFilterbtn']")).click(); //Applying filter on Institution
		
		selectInst=driver.findElement(By.xpath("//td[text()='"+Institution+"']")); // Selecting institution from the list
		actObj.click(selectInst).build().perform();
		
		try{
			Thread.sleep(5 * 1000);
			}catch(InterruptedException ie){}
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and text()='Next']/parent::button")).click();
		

		Select inst= new Select(driver.findElement(By.id("instructorSk"))); // Used select class to handle to 'select Instructor' drop-down.
		inst.selectByIndex(1); //Selecting the first element in the drop-down
		
		driver.findElement(By.xpath("//span[@class='ui-button-text' and text()='Next']/parent::button")).click();	
		driver.findElement(By.xpath(".//*[@id='deploymentType' and @value='INSTITUTION']")).click();
		driver.findElement(By.xpath(".//*[@id='deploymentType' and @value='INSTITUTION']")).click();
		driver.findElement(By.xpath(".//input[@id='accessCode']")).click();
		
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and text()='Next']/parent::button")).click();
		try{
			Thread.sleep(3 * 1000);
			}catch(InterruptedException ie){}
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and text()='Next']/parent::button")).click();
		
		String deploymentID= driver.findElement(By.xpath("//div[@class='title smaller']")).getText(); //fetching Deployment ID
		System.out.println("Deployment ID="+deploymentID);
		System.out.println("Institution used="+Institution);
		driver.findElement(By.xpath(".//input[@id='txtNothing1']")).sendKeys("kunaaldwivedi@qainfotech.net");

		try{
			Thread.sleep(3 * 1000);
			}catch(InterruptedException ie){}
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and text()='Next']/parent::button")).click();
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and text()='Deploy for Testing']/parent::button")).click();
		try{
			Thread.sleep(6 * 1000);
			}catch(InterruptedException ie){}
		driver.findElement(By.xpath("//span[@Class='ui-button-text' and @data-bind='text: submitText']/parent::button")).click();
	
		DTWinHandle = driver.getWindowHandle(); // Getting the current WindowHandle for future switches
	}
}
