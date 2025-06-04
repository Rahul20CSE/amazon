package com.crm.POM;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePOM {
	
	public homePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	public void serch(String data) {
		search.sendKeys(data);
	}
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchButton;
	
	public void searchButton() {
		searchButton.click();
	}
	
	@FindBy(id="nav-cart")
	private WebElement cart;

	public void cart() {
		cart.click();
	}
	
	
	@FindBy(xpath="//span[contains(text(),'laptop')]")
	private WebElement laptopText;
	
	public WebElement laptopText() {
		return laptopText;
	}

	@FindBy(xpath="//span[contains(text(),'No results for ')]")
	private WebElement NoResult;
	
	public WebElement Invalid() {
		return NoResult;
	}
	
	@FindBy(css="a-size-medium-plus a-spacing-none a-color-base a-text-bold")
	private WebElement Result;
	
	public WebElement result() {
		return Result;
	}
	
	@FindBy(css = "a.a-link-normal.s-link-style.a-text-normal")
	private List<WebElement> searchProduct;

	public void clickFourthProduct() {
	    if (searchProduct.size() >= 4) {
	        searchProduct.get(3).click(); 
	    } else {
	        throw new RuntimeException("Less than 4 products found in search results. Found: " + searchProduct.size());
	    }
	}

}
