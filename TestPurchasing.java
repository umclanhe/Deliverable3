package webtesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * As a user, 
 * I want to add an item to the shopping cart, 
 * so that I can proceed to checkout.
 * @author Lan
 *
 */


public class TestPurchasing {
        
	        WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	        driver.get("https://www.amazon.com");
	        driver.findElement(By.linkText("Sign in")).click();
	        driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
		
	}
	
// Given I'm signed in and my shopping cart is empty
// And use search tool to find an item I want to buy
// And click the link of the item to navigate to the product & shopping cart page
// When I click "Add to Cart"
// Then the confirmation message is displayed on the new page.
		
	@Test
	public void testAddItem1() {
		
// select the category Books, enter specific book name and then click search
// find the item that you want to buy and click the link of the item name
// add the item into the cart and check the confirmation message
		
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByValue("search-alias=stripbooks");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the little prince ");
		WebElement schdiv = driver.findElement(By.cssSelector("#nav-search .nav-search-submit .nav-input"));
		schdiv.click();
		WebElement lk = driver.findElement(By.linkText("The Little Prince"));
		lk.click();
		driver.findElement(By.id("add-to-cart-button")).click();
		
		try
		{
		WebElement ew = driver.findElement(By.id("confirm-text"));
		String msg = ew.getText();
		assertTrue(msg.contains("1 item added to Cart"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
	
	
// Given I'm signed in and there is one item in my shopping cart 
// And use search tool to find another item I want to buy
// And click the link of the item to navigate to the product & shopping cart page
// When I click "Add to Cart"
// Then the number of items in the shopping cart becomes two.
		
	@Test
	public void testAddItem2() {
		
// select the category Books, enter specific book name and then click search
// find the item that you want to buy and click the link of the item name
// add the item into the cart and see if the number in the cart is changed
		
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByValue("search-alias=stripbooks");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("trumpet of the swan ");
		WebElement schdiv = driver.findElement(By.cssSelector("#nav-search .nav-search-submit .nav-input"));
		schdiv.click();
		WebElement lk = driver.findElement(By.linkText("The Trumpet of the Swan"));
		lk.click();
		driver.findElement(By.id("add-to-cart-button-ubb")).click();
		
		try
		{
		WebElement ew = driver.findElement(By.id("nav-cart-count"));
		String msg = ew.getText();
		assertTrue(msg.contains("2"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 

}
