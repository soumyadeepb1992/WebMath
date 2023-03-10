package com.webmath.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.webmath.qa.base.TestBase;
import com.webmath.qa.util.TestUtil;

public class MathForEveryonePage extends TestBase{

	//Page Factory or Object Repository

	@FindBy(id="topicItem")
	WebElement mathHelpdropDown;

	@FindBy(xpath="//div[@class='d-quickJumpRight']/a")
	WebElement goBtn;

	@FindBy(xpath="//div[@id=\"d-logo\"]/a/img")
	WebElement webMathLogo;

	@FindBy(name="param0")
	WebElement volume;





	//Initializing Page objects:

	public MathForEveryonePage() {
		PageFactory.initElements(driver, this);
	}


	//Actions:

	public String validateMathForEveryonePageTitle() {
		return driver.getTitle();
	}

	public boolean validateWebMathLogo() {
		return webMathLogo.isDisplayed();
	}

	public AnswerPage converionVolume(int vol, String from, String to) {

		// Selecting the drop-down 
		Select drop_down = new Select(driver.findElement(By.cssSelector("select[id *='topicItem']")));

		// matching the desired option[ Conversion, Volume]
		drop_down.selectByVisibleText("Conversion, Volume");

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		//Enter the principal amount
		volume.sendKeys(String.valueOf(vol));

		// Selecting the drop-down From
		Select fromDrop_down = new Select(driver.findElement(By.name("param1")));

		// matching the desired option[ gallon(s)]
		fromDrop_down.selectByVisibleText(from);


		// Selecting the drop-down To
		Select toDrop_down = new Select(driver.findElement(By.name("param2")));

		// matching the desired option[ gallon(s)]
		toDrop_down.selectByVisibleText(to);



		//Click on Find the Amount of interest 
		WebElement convertBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		convertBtn.click();

		return new AnswerPage();
	}

}
