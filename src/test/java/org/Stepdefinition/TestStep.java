package org.Stepdefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.Amazon.HomePage;
import org.Amazon.NewPage;
import org.POM.Base.UserBaseClass;

import io.cucumber.java.en.Given;

public class TestStep extends UserBaseClass{

	String windowhome;

	@Given("Launch the url {string}")
	public void launch_the_url(String url) throws InterruptedException {
		urlLaunch(url);
		maximize();
		Thread.sleep(2000);

	}


	@Given("Search the product in search menu and pass ther value {string} and submit the search option")
	public void search_the_product_in_search_menu_and_pass_ther_value_and_submit_the_search_option(String value) throws AWTException, InterruptedException {
		HomePage hp = new HomePage();
		sendKeys(hp.getSearch(), value);

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		clicks(hp.getProduct());

		// to get the window id
		windowhome = driver.getWindowHandle();
		System.out.println("Parent window =" + windowhome);

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("All window =" + windowHandles);

		List <String> li = new ArrayList(windowHandles);
		String newwindow = li.get(1);
		driver.switchTo().window(newwindow);
		Thread.sleep(2000);


	}

	@Given("Move to new tab and click the add to cart button")
	public void move_to_new_tab_and_click_the_add_to_cart_button() throws InterruptedException {
		NewPage np = new NewPage();
		clicks(np.getAadcart());
		Thread.sleep(4000);
		close();
	}


	@Given("Close the new tab and bring the control to home page and refresh the page.")
	public void close_the_new_tab_and_bring_the_control_to_home_page_and_refresh_the_page() throws InterruptedException {
		driver.switchTo().window(windowhome);
		Thread.sleep(4000);
		refresh();
		Thread.sleep(2000);
		NewPage np = new NewPage();
		clicks(np.getHomecart());

	}

}
