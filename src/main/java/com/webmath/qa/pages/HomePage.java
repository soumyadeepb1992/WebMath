package com.webmath.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.util.TestUtil;

public class HomePage extends TestBase{

	//Page Factory or Object Repository

	@FindBy(id="topicItem")
	WebElement mathHelpdropDown;

	@FindBy(xpath="//form[@id='jumpToPage']/div/a/img")
	WebElement goBtn;

	@FindBy(xpath="//div[@id=\"d-logo\"]/a/img")
	WebElement webMathLogo;

	@FindBy(name="principal")
	WebElement principal;

	@FindBy(name="interest")
	WebElement interest;

	@FindBy(name="desired_time")
	WebElement year;

	@FindBy(xpath="//a[@title='Math for Everyone']")
	WebElement mathForEveryoneLink;

	@FindBy(xpath="//a[@title='General Math']")
	WebElement generalMathLink;

	@FindBy(xpath="//a[@title='Kindergarten - 8th Grade Math']")
	WebElement k8MathLink;

	@FindBy(xpath="//a[@title='Algebra']")
	WebElement algebraLink;

	@FindBy(xpath="//a[@title='Plots and Geometry']")
	WebElement plotsAndGeometryLink;

	@FindBy(xpath="//a[@title='Triginometry and Calculus']")
	WebElement trigoAndCalculuLink;

	@FindBy(xpath="//a[@title='Other Fun Math Stuff']")
	WebElement otherStuffLink;


	//Initializing Page objects:

	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	//Actions:

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateWebMathLogo() {
		return webMathLogo.isDisplayed();
	}

	public MathForEveryonePage clickOnmathForEveryoneLink() {
		mathForEveryoneLink.click();
		return new MathForEveryonePage();
	}

	public GeneralMathPage clickOnGeneralMathLink() {
		generalMathLink.click();
		return new GeneralMathPage();
	}

	public K8MathPage clickOnk8MathLink() {
		k8MathLink.click();
		return new K8MathPage();
	}

	public AlgebraPage clickOnalgebraLink() {
		algebraLink.click();
		return new AlgebraPage();
	}

	public PlotsGeometryPage clickOnplotsAndGeometryLink() {
		plotsAndGeometryLink.click();
		return new PlotsGeometryPage();
	}

	public TrigCalculusPage clickOntrigoAndCalculuLink() {
		trigoAndCalculuLink.click();
		return new TrigCalculusPage();
	}

	public OtherStuffPage clickOnotherStuffLink() {
		otherStuffLink.click();
		return new OtherStuffPage();
	}



	public AnswerPage simpleInterest(int prin, int rate, int time) {

		// Selecting the drop-down 
		Select drop_down = new Select(driver.findElement(By.cssSelector("select[id *='topicItem']")));

		// matching the desired option[ Interest , simple]
		drop_down.selectByVisibleText("Interest, Simple");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		//Enter the principal amount
		principal.sendKeys(String.valueOf(prin));

		//Enter the percent of interest 
		interest.sendKeys(String.valueOf(rate));

		//Enter the year 
		year.sendKeys(String.valueOf(time));

		//Click on Find the Amount of interest 
		WebElement findBtn = driver.findElement(By.cssSelector("input[value='Find the amount of interest']"));
		findBtn.click();

		return new AnswerPage();
	}

}
