package codingRound;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageContainer.HotelBookingPage;

public class HotelBooking {

	Wrapper wrapper = new Wrapper();
	WebDriver driver;
	WebElement element;
	HotelBookingPage objHotelBookingPage;

	@BeforeClass
	public void tearUp() {
		wrapper.setDriverPath();	
		driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
	}

	@Test
	public void shouldBeAbleToSearchForHotels() {
		objHotelBookingPage = new HotelBookingPage(driver);  //Instantiated 
		Assert.assertEquals(true, objHotelBookingPage.hotelSearch());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
