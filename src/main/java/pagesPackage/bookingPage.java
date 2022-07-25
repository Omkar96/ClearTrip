package pagesPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basePackage.BaseClass;

public class bookingPage extends BaseClass {

	WebDriver driver;

	public bookingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void LowestPriceforCurrentWeek() {

		List<WebElement> prices = driver
				.findElements(By.xpath("//div[@class=\"sticky__parent\"]//div[@class=\"flex flex-middle\"]/p"));
		String[] fare = new String[prices.size()];
		
		//sorting the price for this week
		for (int i = 0; i < prices.size(); i++) {
			fare[i] = prices.get(i).getText();
		}
		Arrays.sort(fare);

		//CLicking on lowest flight of day
		for (WebElement price : prices) {
			if (price.getText().equals(fare[0])) {
				price.click();
				break;
			}
		}

		//Going to Booking Page
		String parenthandle = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(string(),'Book')]")));
		driver.findElement(By.xpath("//button[contains(string(),'Book')]")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		SwitchTabtoBookingPage(parenthandle);
		
	}
	
	private void SwitchTabtoBookingPage(String Handle) {
		Set<String> window = driver.getWindowHandles();
        for(String var: window)
        {
      	  if  (!var.equalsIgnoreCase(Handle))
      	  {
      		  driver.switchTo().window(var);
      	  }
      	     
        }
	}
}
