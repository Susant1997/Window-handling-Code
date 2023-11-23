package org.Amazon;

import org.POM.Base.UserBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewPage extends UserBaseClass{
	
	public NewPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"add-to-cart-button\"]")
	private WebElement aadcart;

	public WebElement getAadcart() {
		return aadcart;
	}
	@FindBy(how=How.XPATH,using="//a[@id='nav-cart']")
	private WebElement homecart;

	public WebElement getHomecart() {
		return homecart;
	}
	
	
}
