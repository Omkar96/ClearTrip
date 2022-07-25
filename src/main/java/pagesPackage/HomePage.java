package pagesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseClass;

public class HomePage extends BaseClass {

	WebDriver driver;
	
	By populardropdown = By.xpath("//ul[contains(string(),'Popular searches')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EnterDepartureLocation(String text) {
		//Selecting the departure location
		driver.findElement(By.xpath("//h4[contains(string(),'From')]//following-sibling::div/div/div/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(populardropdown));
		
		//iterating and selecting desired options
		java.util.List<WebElement> from = driver.findElements(By.xpath("//ul[contains(string(),'Popular searches')]/li/p"));
		SelectOptionInDropDownUsingIteration(from, text);
	}
	
	public void EnterDestinationLocation(String text) {
		//Selecting the departure location
		driver.findElement(By.xpath("//h4[contains(string(),'To')]//following-sibling::div/div/div/input")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(populardropdown));
		
		//iterating and selecting desired options
		java.util.List<WebElement> To = driver.findElements(By.xpath("//ul[contains(string(),'Popular searches')]/li/p"));
		SelectOptionInDropDownUsingIteration(To, text);
	}
	
	private void SelectOptionInDropDownUsingIteration(java.util.List<WebElement> dropdownoptions, String optionToBeSelected) {
		boolean flag = false;
		
		for(WebElement option : dropdownoptions) {
			if(option.getText().equals(optionToBeSelected)) {
				option.click();
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			System.out.println("City not found");
		}
	}
	
}
