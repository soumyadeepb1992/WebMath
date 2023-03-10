package com.webmath.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.pages.AnswerPage;
import com.webmath.qa.pages.HomePage;
import com.webmath.qa.pages.MathForEveryonePage;

public class MathForEveryoneLinkTest extends TestBase{
	
	HomePage homePage;
	AnswerPage answerPage;
	MathForEveryonePage mathForEveryonePage;

	public MathForEveryoneLinkTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		
		mathForEveryonePage = homePage.clickOnmathForEveryoneLink();
		
	}
	
	@Test(priority = 1)
	public void validateMathForEveryonePageTitle() {
		String MathForEveryonePageTitle = mathForEveryonePage.validateMathForEveryonePageTitle();
		Assert.assertEquals(MathForEveryonePageTitle, "Math for Everyone - WebMath", "MathForEveryone Page title not matched.");
		
	}
	
	@Test(priority = 2)
	public void WebMathLogoImageTest() {
		boolean flag = mathForEveryonePage.validateWebMathLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void volumeConversionTest() {
		mathForEveryonePage.converionVolume(10, "gallon(s)", "liter(s)");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
