package org.StepDefinition2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.Amazon.HomePage;
import org.Amazon.NewPage;
import org.Amazon.Newtab;
import org.POM.Base.UserBaseClass;
import org.apache.poi.ss.formula.functions.Replace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class TestStep2 extends UserBaseClass {


	String windowhome;
	@Given("Launch the url {string}")
	public void launch_the_url(String url) throws InterruptedException {
		urlLaunch(url);
		maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
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



	}


	@Given("Move to new tab and click the add to cart button")
	public void move_to_new_tab_and_click_the_add_to_cart_button() throws InterruptedException {

		NewPage np = new NewPage();
		//		System.out.println("Products and Prices");
		findelements("//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Apple iPhone 14')]");
//		for (int i = 0; i < elements.size(); i++) {
		for (int i = 0; i < 3; i++) {
			WebElement element = elements.get(i);
			element.click();
			Thread.sleep(2000);
			//			   String text = element.getText();
			//			   System.out.println(text);
		}
		windowhome = driver.getWindowHandle();

		System.out.println("Parent window - " +windowhome);

		Set<String>  windowHandles = driver.getWindowHandles();
		System.out.println("Windows ID");
		System.out.println(windowHandles);
		List <String> li1 = new ArrayList(windowHandles);

		for (int i = 1; i < li1.size(); i++) {
			String newwindow = li1.get(i);
			driver.switchTo().window(newwindow);
			Thread.sleep(2000);
			clicks(np.getAadcart());
			Thread.sleep(2000);
			close();

		}
	}


	@Given("Close the new tab and bring the control to home page and refresh the page.")
	public void close_the_new_tab_and_bring_the_control_to_home_page_and_refresh_the_page() throws InterruptedException, IOException {

		NewPage ns = new NewPage();
		driver.switchTo().window(windowhome);
		refresh();
		Thread.sleep(2000);
		clicks(ns.getHomecart());
		Thread.sleep(2000);


		List<WebElement> titlelist = findelements("//span[@class='a-truncate-cut']");
		List<WebElement> pricelist = findelements("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']");
//		double totalSum = 0;
		int b = 0;
		for (int i = 0; i < titlelist.size(); i++) {
			WebElement element1 = titlelist.get(i);
			String title = element1.getText();
			Thread.sleep(2000);

			WebElement element2 = pricelist.get(i);
			String price = element2.getText();
			String replace1 = price.replace(".00", "");
			String replace2 = replace1.replace(",", "");
			String replace3 = replace2.trim();
			int a = Integer.parseInt(replace3);
			 b = b +a;
			 
			 
			 
			 
//			 double numericPrice = Double.parseDouble(price.replaceAll("[^0-9.]", ""));
//			    totalSum += numericPrice;
			int k = i+1;
			System.out.println(i+1 + title + "-" + price);
			writeExcel(i, 0, k, 1, title, 2, price );
		}
		
		System.out.println(b);
		String subtotal = Integer.toString(b);
		WebElement element = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']"));
		 String text = element.getText();
		 String replace4 = text.replace(".00", "");
		 String replace5 = replace4.replace(",", "");
		 String total = replace5.trim();
		 System.out.println(total);
		 boolean c = subtotal.equals(total);
		 System.out.println(c);
		 int l = subtotal.length();
		 System.out.println(l);
		 int l2 = total.length();
		 System.out.println(l2);
		 int l3 = System.identityHashCode(subtotal);
		 System.out.println(l3);
		 int l4 = System.identityHashCode(total);
		 System.out.println(l4);
		 
		if (subtotal.equals(total)) {
			
			System.out.println("Both Total are equal");
			
		}
		else {
			System.out.println("Both total are not equal");
		}
//		System.out.println("Total Price: " + totalSum);

//		driver.quit();
		//	    List<WebElement> titlelist = driver.findElements(By.xpath("//span[@class='a-truncate-cut']"));
		//	    List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
		//	    
		//	    for (int i = 0; i < titlelist.size(); i++) {
		//	    	WebElement element = titlelist.get(i);
		//	    	String title = element.getText();
		//	    	Thread.sleep(2000);
		//	    	WebElement element2 = pricelist.get(i);
		//	    	String price = element2.getText();
		//	    	Thread.sleep(2000);
		//	    	int j = i+1;
		//	    	System.out.println(j + "-" + title + "-" + price);
		//	    	writeExcel(i, 0, j, 1, title, 2, price);
		//	}



	}





}


