package com.motionintegrator.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.motionintegrator.pages.BasePage;

public class BaseTest extends BasePage {
	
	@BeforeSuite
	public void initStart() {
		Assert.assertTrue(goToHomepage(), "ERROR: Cannot navigate to the home page!");
	}
	
	
	@AfterSuite
	public void endTest() {
		//close the browser
		closeBrowser();
	}

}
