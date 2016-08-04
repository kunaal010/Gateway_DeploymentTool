package com.qait.gateway.testCases;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.gateway.Utils.UiUtils;
import com.qait.gateway.deploytool.DeploymentToolLogin;
import com.qait.gateway.deploytool.GatewayCourseCreationAndActivityImport_D2L;
import com.qait.gateway.deploytool.LMSLaunchAndLogin_D2L;
import com.qait.gateway.deploytool.LTICourseCreation;
import com.qait.gateway.deploytool.PartnerCourseTest;

public class TestSuite_1 extends UiUtils{
	
	static WebDriver driver;
	static WebDriver driver1;
	@BeforeClass
	public WebDriver PreConditions(){
		String browser=JOptionPane.showInputDialog("Brower?");	//JOption pane to take the input for desired browser
		return driver=SelectBrowser(browser);
	}
	@Test
	public void logginIntoDeploymentTool() throws InterruptedException {
		new DeploymentToolLogin().ValidLogin(driver);
	}
	@Test
	public void createLTICourse(){
		new LTICourseCreation().createMindTapCourse(driver);
	}
	@Test
	public void testingTheCreatedCourse(){
		new PartnerCourseTest().courseTest(driver);
	}
	
	@Test
	public void launchOfLMSandLogin(){
		driver1 = new FirefoxDriver();
		driver1= new LMSLaunchAndLogin_D2L().LMSLaunch_Login(driver1);
	}
	
	@Test
	public void gatewayCourseCreation(){
		new GatewayCourseCreationAndActivityImport_D2L().CC_1stOption("", driver1);
	}
	
	
}
