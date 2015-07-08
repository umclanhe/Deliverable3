package webtesting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user, 
 * I want to log in successfully, 
 * so that I can have access to my account.
 * @author Lan
 *
 */

    public class SignInTest {
    	
	    WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	    driver.get("https://www.amazon.com");
	    driver.findElement(By.linkText("Sign in")).click();
	}
	
//	Given I opened the amazon website
//  And click ¡°Sign in¡± button to navigate to the Sign In page
//  When I fill in correct username, but incorrect password and click ¡°sign in using our secure server¡± button
//  Then I see error message ¡°There was a problem with your request¡± displayed on the new page.
			
	@Test
	public void testBadPassword() {
		
		// fill in the email and password to log in
		
		driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("6080");
		driver.findElement(By.id("signInSubmit-input")).click();
		
		try
		{
		WebElement me = driver.findElement(By.id("message_error"));
		String errmg = me.getText();
		assertTrue(errmg.contains("There was a problem with your request"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 
	
//	Given I opened the amazon website
//  And click ¡°Sign in¡± button to navigate to the Sign In page
//  When I fill in correct username, password and click ¡°sign in using our secure server¡± button
//  Then I see ¡°tulipsu¡¯s Amazon¡± displayed on the new page.
	
	@Test
	public void testSuccessLogIn() {
		
		// fill in the email and password to log in
		
		driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
		
		try
		{
		WebElement mct = driver.findElement(By.id("nav-your-amazon"));
		String str = mct.getText();
		assertTrue(str.contains("tulipsu's Amazon.com"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	} 

}
