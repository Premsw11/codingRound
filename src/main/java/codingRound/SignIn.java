package codingRound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageContainer.SignInPage;

public class SignIn {

	Wrapper wrapper = new Wrapper();
	SignInPage objSignInPage;
	WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public void tearUp() {
		wrapper.setDriverPath();	
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
	}
	
	@Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		objSignInPage = new SignInPage(driver);
        Assert.assertTrue(objSignInPage.errorVerification().contains("There were errors in your submission"));
    }

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
