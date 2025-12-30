import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakingAppointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  ChromeOptions options = new ChromeOptions();
	  Map<String, Object> prefs = new HashMap<>();
	  prefs.put("profile.password_manager_leak_detection", false);
	  prefs.put("profile.credentials_enable_service", false);
	  options.setExperimentalOption("prefs",prefs);
	 
		WebDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.findElement(By.id("btn-make-appointment")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		
		WebElement dropdown = driver.findElement(By.name("facility"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Seoul CURA Healthcare Center");
		
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		
		driver.findElement(By.id("radio_program_medicare")).click();
		
		driver.findElement(By.xpath("//span[contains(@class, 'glyphicon glyphicon-calendar')]")).click();
		
	    String targetMonthYear = "January 2026";

		while (true) {
		    String currentMonthYear = driver.findElement(By.xpath("//th[@class='datepicker-switch']") ).getText();

		    if (currentMonthYear.equals(targetMonthYear)) {
		        break;
		    }

		    driver.findElement(By.xpath("//th[@class='next']")).click();
		    
		    
		   
		    driver.findElement(By.xpath("//td[text()='15' and not(contains(@class,'old'))]")).click();  
		    
		    driver.findElement(By.id("txt_comment")).sendKeys("I would like to book an appointment with the doctor for a general health consultation. I am experiencing mild symptoms and would appreciate an available slots at your earliest convenience.");
		    	
		    driver.findElement(By.id("btn-book-appointment")).click();
		    
		}
	
	}

}
