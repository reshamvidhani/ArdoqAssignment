package cc.selenium.webdriver.basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AmazonFictionBooks extends ObjectRepository{
	
	public static WebDriver driver = null;
	
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", chromePath);
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @Test
  public void test() throws InterruptedException {
	  	driver.navigate().to("https://amazon.in");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		/*
		 * Get the title of the page
		 */
		String title = driver.getTitle();
		
		/*
		 * Verify if user has landed to correct page
		 */
		try {
			assertEquals(expectedTitle, title);	
		} catch (Error e) {
			System.out.println(title + " - Text not found");	
			driver.quit();
		}
		
		/*
		 * Select Shop all category
		 */
		WebElement category = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(mainCategory))));
		category.click();
	    
		/*
		 * Select Books & Audible from Category list
		 */
		WebElement booksCategory = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(selectBookCat))));
		booksCategory.click();
		
		/*
		 * Select Fiction Books from Books & Audible Category
		 */
		WebElement bookType = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(selectBookSubCat))));
		bookType.click();
		
		/*
		 *  Enter John Grisham in the search text box
		 */
		WebElement bookName = driver.findElement(By.id(enterBookToSearch));
		bookName.sendKeys("John Grisham");
		Thread.sleep(2000);
		bookName.sendKeys(Keys.ENTER);
		
		/*
		 * here COMMAND is used to open book in new tab, for Windows maching CONTROL must be used
		 */
		 String selectLinkOpeninNewTab = Keys.chord(Keys.COMMAND,Keys.RETURN); //For Mac machine
		// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN); // For Windows machine
		 WebElement selectBook = driver.findElement(By.linkText(bookToBuy));
		 selectBook.sendKeys(selectLinkOpeninNewTab);
		 
		 
		 /*
		  * Open the tab which has just opened with book details
		  */
		 java.util.Set<String> handles = driver.getWindowHandles();
		 String winHandle1 = driver.getWindowHandle();
		 handles.remove(winHandle1);
		 
		 String winHandle = handles.iterator().next();
		 String winHandle2 = " ";
		 if(winHandle!=winHandle1) {
			 winHandle2 = winHandle;
			 driver.switchTo().window(winHandle2);
			 System.out.println(winHandle2);
		 }
		 
		 WebElement productToCart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(addToCart))));
		 productToCart.click();
		 
		 WebElement buyBook = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(purchaseToBuy))));
		 buyBook.click();
		 
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
