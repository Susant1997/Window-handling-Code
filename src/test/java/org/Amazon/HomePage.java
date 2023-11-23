package org.Amazon;

import org.POM.Base.UserBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UserBaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@id='twotabsearchtextbox']")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	
	@FindBy(how=How.XPATH,using="//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Apple iPhone 14')]")
	private WebElement product;

	public WebElement getProduct() {
		return product;
	}
	
	@FindBy(how=How.XPATH,using="//span[@class='a-price']")
	private WebElement price;

	public WebElement getPrice() {
		return price;
	}

	
}
