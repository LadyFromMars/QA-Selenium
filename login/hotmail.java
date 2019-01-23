package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class hotmail {

	public static void main(String[] args) throws InterruptedException {
		

		
		//Gecko driver
		System.setProperty("webdriver.gecko.driver", "/Users/natallia/eclipse-workspace/LoginTest/lib/gecko-drivers/geckodriver");
		
		WebDriver HMdriver = new FirefoxDriver();
		
		
		// launch Fire fox and open URL
		String hmUrl = "https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1548198814&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3A%2F%2Faccount.microsoft.com%2Fauth%2Fcomplete-signin%3Fru%3Dhttps%253A%252F%252Faccount.microsoft.com%252Fprofile%253Fru%253Dhttps%25253A%25252F%25252Faccount.microsoft.com%25252Fprofile%25252F%2526destrt%253Dprofile-landing%2526refd%253Daccount.microsoft.com%2526refp%253Dsignedout-index&lc=1033&id=292666&lw=1&fl=easi2&ru=https%3A%2F%2Faccount.microsoft.com%2Faccount%2FManageMyAccount%3Fru%3Dhttps%253A%252F%252Faccount.microsoft.com%252Fprofile%252F%26destrt%3Dprofile-landing";
        HMdriver.get(hmUrl);	
		
		

        
        
       
        
//negative scenario - wrong password
        
        int attemptToLogin =0;     //number of attempts to log in
        String HMemail = "testq592@hotmail.com";    //email
      
        
    	 //insert email and password
        
        HMdriver.findElement(By.id("i0116")).sendKeys(HMemail);
        Thread.sleep(1000);
        HMdriver.findElement(By.id("idSIButton9")).click();
        Thread.sleep(500);
        HMdriver.findElement(By.id("i0118")).sendKeys("fakepsw");
        Thread.sleep(500);
        HMdriver.findElement(By.id("idSIButton9")).click();        
        
       
         //comparing warning message
       
        String PswWarning = "Your account or password is incorrect. If you don't remember your password, reset it now.";
        String pssWarningTest = "";
        pssWarningTest = HMdriver.findElement(By.id("passwordError")).getText();
		
        
        if(PswWarning.contentEquals(pssWarningTest)) {
        	attemptToLogin++;
        	System.out.println("Test passed (negative scenario); Result: incorrect password warning; Number of attempts = " + attemptToLogin);
        	
        } else {
        	System.out.println("Test fail (negative scenario): incorrect password input;");
        }
        
        
        //loop input
        
        for(int i=0; i<2; i++) {
        	
        	Thread.sleep(500);
        	HMdriver.findElement(By.id("i0118")).sendKeys("fakepsw");
            Thread.sleep(500);
            HMdriver.findElement(By.id("idSIButton9")).click();
          
          //comparing warning message
            
            if(PswWarning.contentEquals(pssWarningTest)) {
            	attemptToLogin++;
            	System.out.println("Test passed (negative scenario); Result: incorrect password warning; Number of attempts = " + attemptToLogin);
            	
            } else {
            	System.out.println("Test fail (negative scenario): incorrect password input;");
            }
        	
        }
        
        
        
//positive scenario
        
        
        // launch Fire fox and open URL
           
        	HMdriver.get(hmUrl);
           
           //input email and password
        	
           HMdriver.findElement(By.id("i0116")).clear();  //clearing email field
           Thread.sleep(500);
           HMdriver.findElement(By.id("i0116")).sendKeys(HMemail);
           Thread.sleep(500);
           HMdriver.findElement(By.id("idSIButton9")).click();
           Thread.sleep(500);
           HMdriver.findElement(By.id("i0118")).sendKeys("QAEng1neerT3st");
           Thread.sleep(500);
           HMdriver.findElement(By.id("idSIButton9")).click(); 
           Thread.sleep(2000);
           
           
         //comparing the actual title with expected to get a prove of successful login(should include hmAccountTitle)
           
           String hmAccountTitle = "Your profile";
           String hmActualAccountTitle = "";
           
           hmActualAccountTitle = HMdriver.getTitle();

           
           Thread.sleep(5000);
           
           if (hmActualAccountTitle.contains(hmAccountTitle)){
               System.out.println("Test passed (positive scenario): You successfully loged in");
           } else {
               System.out.println("Test fail (positive scenario): Unsuccessful log in");
           }
   		
           
           
          
        
		HMdriver.quit(); //close 

	}

}
