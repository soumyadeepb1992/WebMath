package com.webmath.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.pages.AnswerPage;
import com.webmath.qa.pages.HomePage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	AnswerPage answerPage;
	
	public HomePageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "WebMath - Solve Your Math Problem", "Home Page title not matched.");
		
	}
	
	@Test(priority = 2)
	public void WebMathLogoImageTest() {
		boolean flag = homePage.validateWebMathLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void simpleInterestTest() {
		answerPage = homePage.simpleInterest(10000, 10, 2);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
