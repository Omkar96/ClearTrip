package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagesPackage.HomePage;
import pagesPackage.bookingPage;

public class Booking extends BaseClass {

	HomePage home;
	bookingPage book;
	
	@BeforeSuite
	public void intialize() {
		initialize();
		home = new HomePage(driver);
		book = new bookingPage(driver);
	}
	
	@BeforeTest
	public void removepopup(){
		//cancelling the signup pop up
		WebElement popup = driver.findElement(By.xpath("//*[@class=' c-pointer c-neutral-900']"));
		if(popup.isDisplayed() == true) {
			popup.click();
		}
	}
	
	@Test
	public void BangloreToDelhi() {
		
		//Selecting the departure location
		home.EnterDepartureLocation("Bangalore, IN - Kempegowda International Airport (BLR)");
		
		//selecting the destination/arrival location
		home.EnterDestinationLocation("New Delhi, IN - Indira Gandhi Airport (DEL)");
		
		//click on Search flight button
		driver.findElement(By.xpath("//button[contains(string(),'Search flights')]")).click();
		
		//waiting till page loads
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"flex w-100\"]"))));
		
		//get lowest prices of the current week
		book.LowestPriceforCurrentWeek();
		
		
		
	}
	
}
