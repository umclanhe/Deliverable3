package webtesting;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
* As a user,
* I want to delete an item from my shopping cart,
* So that I can update the information in my shopping cart.
*/

public class TestUpdateCart {
	
        WebDriver driver = new FirefoxDriver();
	
	//Start at the home page for Amazon for each test
	@Before
	public void setUp() throws Exception {
		
		driver.get("https://www.amazon.com");
		
		driver.findElement(By.linkText("Sign in")).click();						
		driver.findElement(By.name("email")).sendKeys("sd1111@gmail.com");
		driver.findElement(By.name("password")).sendKeys("caiwei123");				 	
		driver.findElement(By.id("signInSubmit-input")).click();				
		driver.findElement(By.id("nav-cart")).click();
		
	}
	
// Given that I am on the shopping cart page,
// When I press the "Delete" button under the item
// Then the item was removed from shopping cart.

	@Test
	public void testDeleteItem() {
		
		// look for the delete button and click to delete the item
		WebElement actionLinks = driver.findElement(By.className("sc-action-links"));
		
		WebElement deleteLink = actionLinks.findElement(By.className("a-declarative"));
//		WebElement deleteLink = driver.findElement(By.name("submit.delete.CGNVY44IJPDZL"));
		deleteLink.click();
		
		try{
			WebElement remItem = driver.findElement(By.className("sc-list-item-removed-msg"));
			String st = remItem.getText();
			assertTrue(st.contains("was removed from Shopping Cart"));
			}catch (NoSuchElementException nseex) {
				fail();
			}		
   }
	
	
// Given that I am on the shopping cart page,
// When I press the Saved for later button under the item,
// Then the item was removed from my shopping cart.
	
	@Test
	public void testSaveForLaterItem(){
	
	//look for the Save For Later button and click to save the item in the later list.
	WebElement actionLinks = driver.findElement(By.className("sc-action-save-for-later"));
	
	WebElement SaveForLaterLink = actionLinks.findElement(By.className("a-declarative"));
//	WebElement SaveForLaterLink = driver.findElement(By.name("submit.save-for-later.C2ZA41IYVX3HX5"));	
	SaveForLaterLink.click();
	
	WebElement saveItem = driver.findElement(By.className("sc-list-caption"));
	String elementText = saveItem.getText();
    assertTrue(elementText.contains("Saved for later"));
}
	
}
