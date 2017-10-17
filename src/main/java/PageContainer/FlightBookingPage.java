package PageContainer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import codingRound.Wrapper;

public class FlightBookingPage {

	WebDriver driver;
	Wrapper wrapper = new Wrapper();
	
	@FindBy(id = "OneWay")
	private WebElement OneWay;
	
	@FindBy(id = "FromTag")
	private WebElement fromInputBox;
	
	@FindBy(id = "ui-id-1")
	private List<WebElement> originOption;
	
	@FindBy(id = "ToTag")
	private WebElement toInputBox;
	
	@FindBy(id = "ui-id-2")
	private List<WebElement> destinationOption;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[7]/a")
	private WebElement datePick;
	
	@FindBy(id = "SearchBtn")
	private WebElement searchButton;
	
	@FindBy(className = "searchSummary")
	private WebElement searchSummaryDetails;
	
	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean oneWayflightbooking() {
		
		OneWay.click();
		fromInputBox.clear();
		fromInputBox.sendKeys("Bangalore");
		wrapper.waitForElementVisibility(driver, By.id("ui-id-1"));
		originOption.get(0).click();
		toInputBox.clear();
		toInputBox.sendKeys("Delhi");
		wrapper.waitForElementVisibility(driver, By.id("ui-id-2"));
		destinationOption.get(0).click();
		wrapper.waitForElementPresence(driver, By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[7]/a"));
		datePick.click();
		searchButton.click();
		wrapper.waitForElementPresence(driver, By.className("searchSummary"));
		return wrapper.isElementPresent(driver, By.className("searchSummary"));
		
	}
}
