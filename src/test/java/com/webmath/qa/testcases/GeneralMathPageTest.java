package com.webmath.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.pages.AnswerPage;
import com.webmath.qa.pages.GeneralMathPage;
import com.webmath.qa.pages.HomePage;

public class GeneralMathPageTest extends TestBase{
	
	HomePage homePage;
	AnswerPage answerPage;
	GeneralMathPage generalMathPage;
	
	public GeneralMathPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		
		generalMathPage = homePage.clickOnGeneralMathLink();
		
	}
	
	@Test(priority = 1)
	public void validateGeneralMathPageTitle() {
		String generalMathPageTitle = generalMathPage.validateGeneralMathPageTitle();
		Assert.assertEquals(generalMathPageTitle, "General Math - WebMath", "General Math Page title not matched.");
		
	}
	
	@Test(priority = 2)
	public void WebMathLogoImageTest() {
		boolean flag = generalMathPage.validateWebMathLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void numbersPronouncingTest() {
		generalMathPage.numbersPronouncing(1211);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
