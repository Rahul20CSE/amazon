package com.crm.POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPOM {
	  WebDriver driver;
	public ProductPOM(WebDriver driver) {
		 this.driver = driver; 
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="(//*[@id='add-to-cart-button'])[2]")
	private WebElement addcart;
	
	public void addClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(addcart));
	    wait.until(ExpectedConditions.elementToBeClickable(addcart));
	    addcart.click();
	}
	
	
	
}
