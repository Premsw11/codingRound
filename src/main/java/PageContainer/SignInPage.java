package PageContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {

	WebDriver driver;

	@FindBy(linkText = "Your trips")
	private WebElement yourTripsLink;

	@FindBy(id = "SignIn")
	private WebElement signInLink;

	@FindBy(id = "modal_window")
	private WebElement userLoginIframe;

	@FindBy(id = "signInButton")
	private WebElement signInbutton;

	@FindBy(id = "errors1")
	private WebElement errorCollector;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String errorVerification() {
		yourTripsLink.click();
		signInLink.click();
		driver.switchTo().frame(userLoginIframe);
		signInbutton.click();
		return errorCollector.getText();
	}
}
