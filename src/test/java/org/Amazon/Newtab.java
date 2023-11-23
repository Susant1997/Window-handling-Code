package org.Amazon;

import org.POM.Base.UserBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Newtab extends UserBaseClass{
	
	public Newtab() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//span[@class='a-truncate-cut']")
	private WebElement newtitle;
	
	
	@FindBy(how=How.XPATH,using="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	private WebElement priceamount;


	public WebElement getNewtitle() {
		return newtitle;
	}


	public WebElement getPriceamount() {
		return priceamount;
	}
	

	@FindBy(how=How.XPATH,using="(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
	private WebElement subtotal;
	
	@FindBy(how=How.XPATH,using="(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
	private WebElement subtotal2;


	public WebElement getSubtotal() {
		return subtotal;
	}


	public WebElement getSubtotal2() {
		return subtotal2;
	}
}
