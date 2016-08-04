package com.qait.gateway.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class UiUtils extends MyLocators {
	
		/*private UiUtils(){}
		public static UiUtils utilObject;
		
		public static UiUtils getUiUtils(){
			if (utilObject==null){
				utilObject=new UiUtils();
			}
			return utilObject;
		}*/
		
		public WebDriver SelectBrowser(String browserName){
			WebDriver driver=null;
			if (browserName.equals("Chrome") || browserName.equals("chrome")){
					System.setProperty("webdriver.chrome.driver","D:/KD/Java_works/MyWorkspace/MyProject/chromedriver.exe");
					driver= new ChromeDriver();
			} else if (browserName.equals("IE") || browserName.equals("ie")){
					System.setProperty("webdriver.ie.driver","D:/KD/Java_works/MyWorkspace/MyProject/IEDriverServer.exe");
					driver=new InternetExplorerDriver();
			} else if (browserName.equals("Firefox") || browserName.equals("firefox")){
					driver=new FirefoxDriver();
			} else{
					System.out.println("Browser not supported");
			}
			return driver;
		}

		public void openURL(WebDriver driver,String url){
			driver.get(url);
			
		}
	
		public void fn_Input(WebElement we, String inputText){
			if (we.isDisplayed() && we.isEnabled()){
				we.sendKeys(inputText);
			}
			
		}
		
		public void fn_CheckBoxOn(WebElement we){
			if(we.isDisplayed()){
				if(!we.isSelected()){
					we.click();
				}
			}
			
		}
		
		public void fn_CheckBoxOff(WebElement we){
			if(we.isDisplayed()){
				if(we.isSelected()){
					we.click();
				}
			}
			
		}
	
		public void fn_Click(WebElement we){
			if (we.isDisplayed() && we.isEnabled()){
					we.click();
				}
			}
		
		public void fn_SelectByVisibleTest(WebElement we, String fieldValue){
			new Select(we).selectByVisibleText(fieldValue);
		}
	
		public void fn_switchFrame(WebDriver driver, String nameOrId){
			driver.switchTo().frame(nameOrId);
		}
	
	
		public WebDriver switchToNewWindow(WebDriver driver) {
			try{
				Thread.sleep(3 * 1000);
				}catch(InterruptedException ie){}
		String oldWindow= driver.getWindowHandle();	//Getting the Parent windowHandle information
		System.out.println("Old windowHandle= "+oldWindow); 
	
		Set<String> handleSet= driver.getWindowHandles();	//Pushing the window handles to a Set
		Iterator<String> handleIterator = handleSet.iterator();
		
		while (handleIterator.hasNext()==true){	
			String newWindow = handleIterator.next();
				if(!newWindow.equalsIgnoreCase(oldWindow)){		
					driver.switchTo().window(newWindow);	//Performing the Switch on the Child window
					System.out.println("New Window handle: "+newWindow);
					System.out.println("Title: "+driver.getTitle());
				}
			}
			return driver;
		}
	

		public String dt_TimeStamp(){
			Date myStamp=new Date();
			SimpleDateFormat myFormat=new SimpleDateFormat("hhmmddMMyy");
			return myFormat.format(myStamp);
		}
		
		public String dt_CourseDate(){
			Date courseDate = new Date();
			SimpleDateFormat CourseDateFormat= new SimpleDateFormat("MM/dd/yyyy");
			return CourseDateFormat.format(courseDate);
		}
		
		public String dt_CourseDate_Max(){
			Date dt= new Date();
			Calendar c= Calendar.getInstance();
			c.setTime(dt);
			c.add(Calendar.DATE, 25);
			dt=c.getTime();
			SimpleDateFormat CourseDateFormat=new SimpleDateFormat("MM/dd/yyyy");
			return CourseDateFormat.format(dt);
		}
		
		public String dt_CourseDate_3Days(){
			Date dt= new Date();
			Calendar day = Calendar.getInstance();
			day.setTime(dt);
			day.add(Calendar.DATE, 3);
			dt=day.getTime();
			SimpleDateFormat CourseDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			return 	CourseDateFormat.format(dt);
		}

	
	
	
}
