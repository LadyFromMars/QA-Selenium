package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class googleMail {
	
	
	


	public static void main(String[] args) throws Exception {
		
		// gecko driver
		
		System.setProperty("webdriver.gecko.driver", "/Users/natallia/eclipse-workspace/LoginTest/lib/gecko-drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		// launch Fire fox open URL
		
		String baseUrl = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        driver.get(baseUrl);
        
        
        
        
//Title comparison (to clarify you on the right page)
		
		
		String expectedTitle = "Gmail";
        String actualTitle = "";
        
        actualTitle = driver.getTitle(); //get actual title

        
          //compare the actual title with expected
         
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test passed: Title match");
        } else {
            System.out.println("Test failed: Title mismatch");
        }
		
		
        
        
 //negative scenario - wrong password
        
        int attempt =0;   //number of attempts
        String email = "testq592@gmail.com";
      
     
    	 //input email and password
        
        driver.findElement(By.id("identifierId")).sendKeys(email);
        Thread.sleep(200);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();
        Thread.sleep(300);
        driver.findElement(By.name("password")).sendKeys("fakepsw");
        Thread.sleep(200);
        driver.findElement(By.xpath("//*[@id=\'passwordNext\']")).click();        
        
       
        //comparing warning message
       
        String wrongPswWarning = "Wrong password. Try again or click Forgot password to reset it.";
        String pswWarningTest = "";
        pswWarningTest = driver.findElement(By.xpath("//*[@id=\"password\"]/div[2]/div[2]/div")).getText();
		
        
        if(wrongPswWarning.contentEquals(pswWarningTest)) {
        	attempt++;
        	System.out.println("Test passed (negative scenario); Result: incorrect password warning; Number of attempts = " + attempt);
        	
        } else {
        	System.out.println("Test fail (negative scenario): incorrect password input;;");
        }
        
        
        	//loop input
        
        for(int i=2; i<4; i++) {
        	
        	Thread.sleep(300);
        	driver.findElement(By.name("password")).sendKeys("fakepsw");
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\'passwordNext\']")).click();        
            Thread.sleep(300);
           
            
            
          //comparing warning message
           
            if(wrongPswWarning.contentEquals(pswWarningTest)) {
            	
            	attempt++;	//attempt count
            	
            	System.out.println("Test passed (negative scenario); Result: incorrect password warning; Number of attempts = " + attempt);
            	
            } else {
            	
            	System.out.println("Test fail (negative scenario): incorrect password input;");
            }
        	
        }
        
        
        
 //positive scenario
        
        
        // open URL
        driver.get(baseUrl);
        
        
        //input email and password
        
        driver.findElement(By.id("identifierId")).clear(); //clears email field
        Thread.sleep(300);
        driver.findElement(By.id("identifierId")).sendKeys(email);
        Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();
        Thread.sleep(300);
        driver.findElement(By.name("password")).sendKeys("QAEng1neerT3st");
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[@id=\'passwordNext\']")).click();   
        
        
        String accountTitle = "Inbox - " + email + " - Gmail";
        String actualAccountTitle = "";
        
       
      //comparing the actual title with expected to get a prove of successful login (should be equal)
        
        
        actualAccountTitle = driver.getTitle();
        Thread.sleep(1500);
        
        if (accountTitle.contentEquals(actualAccountTitle)){
            System.out.println("Test passed (positive scenario): You successfully loged in");
        } else {
            System.out.println("Test fail (positive scenario): Unsuccessful log in");
        }
		
        
        
        
		driver.quit(); //close driver
		
	}

}
