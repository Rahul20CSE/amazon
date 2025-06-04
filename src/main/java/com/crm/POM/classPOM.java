package com.crm.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class classPOM {

	  WebDriver driver;
		public classPOM(WebDriver driver) {
			 this.driver = driver; 
			PageFactory.initElements(driver, this);
			
		}
	
	@FindBy(css = "span.a-truncate-cut") 
	private WebElement productName;

	@FindBy(css = "span.a-size-medium.a-color-base.sc-price") 
	private WebElement productPrice;

	@FindBy(css = "span.a-dropdown-prompt") 
	private WebElement quantity;

	
	
	
	@FindBy(css = ".a-icon.a-icon-small-add")
	private WebElement increase;
	
	public void increase() {
		increase.click();
	}
	
	@FindBy(xpath = "//span[@data-a-selector='value']")
	private WebElement quantityValue;
	
	public boolean isQuantityUpdatedToTwo() {
	    String qty = quantityValue.getText().trim();
	    System.out.println("Quantity text: '" + qty + "'");
	    return qty.equals("2") || qty.contains("2");
	}


	public WebElement getQuantityValueElement() {
	    return quantityValue;
	}


	public boolean isProductAdded() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       
	        WebElement cartItemContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("div.sc-list-item-content")));
	        
	        WebElement price = driver.findElement(By.cssSelector("span.a-size-medium.a-color-base.sc-price"));
	        return cartItemContainer.isDisplayed() && price.isDisplayed();
	    } catch (Exception e) {
	        System.out.println("Exception in isProductAdded(): " + e.getMessage());
	        return false;
	    }
	}



	@FindBy(xpath = "//input[@value='Delete' or @aria-label='Delete']")
	private WebElement deleteBtn;

	public void deleteProductFromCart() {
	    deleteBtn.click();
	}
	
	@FindBy(id = "nav-cart-count")
	private WebElement cartCount;

	public boolean isCartEmpty() {
	    return cartCount.getText().trim().equals("0");
	}


	

}
