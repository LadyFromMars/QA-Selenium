package demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

//import static org.testing.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Wiki {

	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//firefox
		//System.setProperty("webdriver.gecko.driver","/Users/natallia/Desktop/QA/@Selenium/Selenium Drivers/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		//chrome
		
		System.setProperty("webdriver.chrome.driver","/Users/natallia/Desktop/QA/@Selenium/Selenium Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		
		driver.get("https://www.wikipedia.org/");
		assertEquals(driver.getTitle().contains("Wikipedia"), true);
		
		WebElement link;
		link = driver.findElement(By.id("js-link-box-en"));
		link.click();
		
		Thread.sleep(3000);
		WebElement searchBox;
		searchBox = driver.findElement(By.id("searchInput"));
		
		//search box
		if (searchBox != null) {
			
			searchBox.sendKeys("Selenium (software)");
			searchBox.submit();
			Thread.sleep(3000);
			driver.getTitle();
			
			System.out.println(driver.getTitle());
			
		//first page
			
			String textFound = driver.findElement(By.id("firstHeading")).getText();
			System.out.println("textFound - " + textFound);
			
			if (textFound.contains("Selenium (software)")) {
				
				System.out.println("test passed");
			} else {
				System.out.println("test failed");
			}
			
		}
		
		driver.close();

	}

}
