package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class googleMail {
	
	
	


	public static void main(String[] args) throws Exception {
		
		//Total test results
		
		int total = 0;
		
		
		// gecko driver
		
		//firefox
		System.setProperty("webdriver.gecko.driver", "/Users/natallia/eclipse-workspace/LoginTest/lib/gecko-drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//google chrome
		
		//System.setProperty("webdriver.chrome.driver", "/Users/natallia/eclipse-workspace/LoginTest/lib/gecko-drivers/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		
		// open URL
		
		String baseUrl = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        driver.get(baseUrl);
        
        
        
        
//Title comparison (to clarify you on the right page)
		
		
		String expectedTitle = "Gmail";
        String actualTitle = "";
        
        actualTitle = driver.getTitle(); //get actual title

        
          //compare the actual title with expected
         
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test passed: Title match; Title: " + actualTitle);
            total++;
        } else {
            System.out.println("Test failed: Title mismatch; Got: " + actualTitle + " Expected: " + expectedTitle);
        }
		
		
        
        
 //negative scenario - wrong password, correct id
        
        System.out.println();
        System.out.println();
        
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
        	total++;
        	System.out.println("Test passed (negative scenario - wrong password, correct id); Result message" + pswWarningTest + "Number of attempts = " + attempt);
        	
        } else {
        	System.out.println("Test fail (negative scenario - wrong password, correct id): incorrect password input; Got Warning: " + pswWarningTest + "Number of attempts = " + attempt);
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
            	total++;
            	
            	System.out.println("Test passed (negative scenario - wrong password, correct id); Result message " + pswWarningTest + "Number of attempts = " + attempt);
            	
            } else {
            	
            	System.out.println("Test fail (negative scenario - wrong password, correct id): incorrect password input; Got Warning: " + pswWarningTest + "Number of attempts = " + attempt);
            }
        	
        } 
        
 //negative scenario - wrong id  
        
        System.out.println();      
        System.out.println();
        
        
        String wrongID = "testq509483@gmail.com";
        int attemptID = 0;
     
        driver.get(baseUrl);
        
        
    	 //input email (id)
        
        for(int i=0; i<3; i++) {
        
        driver.findElement(By.id("identifierId")).clear();
        driver.findElement(By.id("identifierId")).sendKeys(wrongID);
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span")).click();
        Thread.sleep(500);
        
              
   
        //comparing warning message
       
        String wrongIdWarning = "Couldn't find your Google Account";
        String wrongIdTest = "";
        wrongIdTest = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div/div[2]/div[2]/div")).getText();
		
        
        if(wrongIdWarning.contentEquals(wrongIdTest)) {
        	attemptID++;
        	total++;
        	System.out.println("Test passed (negative scenario - wrong id); Result message: " + wrongIdTest + " Number of attempts = " + attemptID);
        	
        } else {
        	System.out.println("Test fail (negative scenario - wrong id); Got Warning: " + wrongIdTest + " Number of attempts = " + attemptID);
        } }
        
        
        
        
        
        
 //positive scenario - correct password, correct id
        
        System.out.println();      
        System.out.println();
        
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
        Thread.sleep(500);
        
        if (accountTitle.contentEquals(actualAccountTitle)){
        	total++;
            System.out.println("Test passed (positive scenario - correct password, correct id): You successfully loged in");
        } else {
            System.out.println("Test fail (positive scenario - correct password, correct id): Unsuccessful log in");
        }
		
       if(total == 8) { //!!!!!! change total if adding new cases
    	   
        System.out.println("ALL TESTS ARE PASSED. Total number of cases passed: " + total);
        
       } else {
    	   
    	   System.out.println("NOT ALL TESTS ARE PASSED. Total number of cases:8; Tests passed: " + total); //!!!!change if total changed
       }
        
		driver.quit(); //close driver
		
	}

}
