package webtesting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * As a user,
 * I would like to create an Amazon account, 
 * So that I can access all information via my account.
 */

public class CreateAccountTest {
	
	    WebDriver driver = new FirefoxDriver();
	
	//Start at the home page for Amazon for each test
	    
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.amazon.com");
		driver.findElement(By.linkText("Start here.")).click();
	}

// Given that I am on the Registration page
// When I try to input unexpected password
// Then there is a error message shown on the page	
	
	@Test
	public void testCreatNewAcct1(){
		
		//Enter user's name
	    driver.findElement(By.name("customerName")).sendKeys("Wei");
	    
	    //Enter user's email address and type it again
	    driver.findElement(By.name("email")).sendKeys("aaaa1234@gmail.com");
		driver.findElement(By.name("emailCheck")).sendKeys("aaaa1234@gmail.com");
		
		//Enter unexpected password and type it again
		driver.findElement(By.name("password")).sendKeys("1");
		driver.findElement(By.name("passwordCheck")).sendKeys("1");
		
		//Look for the Create account button and click
		driver.findElement(By.id("continue-input")).click();
		try {
		WebElement resetPw = driver.findElement(By.id("message_error"));
		assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
		fail();
	}
		
	} 
	
// Given that I am on the Registration page
// When I fill in all information that meets Amazon's requirements
// Then I create an account

	@Test
	public void testCreateNewAcct2(){
		
		//Enter user's name
	    driver.findElement(By.name("customerName")).sendKeys("Wei");
	
	    //Enter user's email address and type it again
	    driver.findElement(By.name("email")).sendKeys("ghf145@gmail.com");
		driver.findElement(By.name("emailCheck")).sendKeys("ghf145@gmail.com");
		
		//Enter user's password and type it again
		driver.findElement(By.name("password")).sendKeys("caiwei123");
		driver.findElement(By.name("passwordCheck")).sendKeys("caiwei123");
		
		//Look for the Create account button and click
		driver.findElement(By.id("continue-input")).click();
		
		//Check if I enter the costumer's page after entering an account
		//The page should include "Recommend for you " in the title
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("Recommended"));
	} 
		
}


