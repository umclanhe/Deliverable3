package webtesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user,
 * I want to view my Amazon account,
 * so that I can get information on my browsing history and system recommendations.
 * @author Lan
 *
 */

public class TestViewAccount {

        WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	    driver.get("https://www.amazon.com");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
	}
	
// Given I'm logged in 
// And click the button "tulipsu's Amazon"
// When I click the link "My Browsing History"
// Then I see the new page of my browsing history	
	
	@Test
	public void testMyBrowseHistory() {
		
        // select the link of my account and click it
		
		WebElement mc = driver.findElement(By.linkText("tulipsu's Amazon.com"));
 	    mc.click();
		
		WebElement ac = driver.findElement(By.linkText("Your Browsing History"));
		ac.click();

		try
		{
		 String title = driver.getTitle();
		 assertTrue(title.contains("Your Browsing History"));		
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
	
// Given I'm logged in 
// And click the button "tulipsu's Amazon"
// When I click the link "Recommended For You"
// Then I navigate to the new page of recommended for you
	
	@Test
	public void testRecommendation() {
		
        // select the link of my account and click it
		
		WebElement et = driver.findElement(By.linkText("tulipsu's Amazon.com"));
 	    et.click();
		
		WebElement rt = driver.findElement(By.linkText("Recommended For You"));
		rt.click();

		try
		{
		 String tt = driver.getTitle();
		 assertTrue(tt.contains("Recommended for You"));		 		
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
}
