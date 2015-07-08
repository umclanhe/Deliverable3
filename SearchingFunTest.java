package webtesting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * As a user, 
 * I want to use the search tool, 
 * so that I can find what I want to buy.
 * @author Lan
 *
 */

    public class SearchingFunTest {
	   
    	        WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	        driver.get("https://www.amazon.com");
	        driver.findElement(By.linkText("Sign in")).click();
	        driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
	}

// Given I¡¯m signed in
// When I choose the option of dropdown list ¡°Books¡± and enter the book name ¡°the little prince¡± and click the button ¡°search¡±
// Then I see the book link ¡°The Little Prince¡± displayed on the new page
	
	@Test
	public void testQuickSearch() {
		
// select the category Books, enter specific book name and then click search
		
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByValue("search-alias=stripbooks");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the little prince ");
		WebElement schdiv = driver.findElement(By.cssSelector("#nav-search .nav-search-submit .nav-input"));
		schdiv.click();
		
		try
		{
		WebElement lk = driver.findElement(By.linkText("The Little Prince"));
		assertTrue(lk.isDisplayed());
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
	
// Given I'm signed in
// When I choose the option of dropdown list "computers" and enter nothing
// Then I see the title "Computers & Accessories" on the new page.
		
	@Test
	public void testAllSearch() {
		
// select the category Computers, enter nothing and then click search
		
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByValue("search-alias=computers");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(" ");
		WebElement schdiv = driver.findElement(By.cssSelector("#nav-search .nav-search-submit .nav-input"));
		schdiv.click();
		
		try
		{
		WebElement lk = driver.findElement(By.className("acs-bgh1-header"));
		String str = lk.getText();
		assertTrue(str.contains("Computers & Accessories"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
	
}
