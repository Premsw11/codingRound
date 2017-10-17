package codingRound;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageContainer.FlightBookingPage;

public class FlightBooking {

	Wrapper wrapper = new Wrapper();
	WebDriver driver;
	FlightBookingPage objFlightBookingPage;
	
	@BeforeClass
	public void tearUp() {
		wrapper.setDriverPath();	
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
	}
	
	@Test
	public void testThatResultsAppearsForOneWay() {
		objFlightBookingPage = new FlightBookingPage(driver);
        //verify that result appears for the provided journey search
        Assert.assertTrue(objFlightBookingPage.oneWayflightbooking());

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
