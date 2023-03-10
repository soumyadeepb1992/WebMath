package com.webmath.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.pages.AnswerPage;
import com.webmath.qa.pages.HomePage;
import com.webmath.qa.pages.K8MathPage;

public class K8MathPageTest extends TestBase{
	
	HomePage homePage;
	AnswerPage answerPage;
	K8MathPage k8MathPage;
	
	public K8MathPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		
		k8MathPage = homePage.clickOnk8MathLink();
		
	}
	
	@Test(priority = 1)
	public void validateK8MathPageTitleTest() {
		String K8MathPageTitle = k8MathPage.validateK8MathPageTitle();
		Assert.assertEquals(K8MathPageTitle, "K-8 - WebMath", "K-8 Page title not matched.");
		
	}
	
	@Test(priority = 2)
	public void WebMathLogoImageTest() {
		boolean flag = k8MathPage.validateWebMathLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void powerConversionTest() {
		k8MathPage.converionPower(100, "watt(s)", "horsepower");
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
