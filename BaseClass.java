package independencyDayMarathonScenarios;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.ReadExcel;

public class BaseClass {
	
	RemoteWebDriver driver;
	Actions builder;
	String excelFileName;
	String chbrowser =" ";
	String edbrowser =" " ;
	String[][] data;
	String[][] data1;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String username, String password) {
	
				
				if (chbrowser.equals("Chrome")) {
					WebDriverManager.chromiumdriver().setup();
					// Handle Browser notifications
					ChromeOptions options = new ChromeOptions();
					// Allow Notifications
					options.addArguments("--disable-notifications");
					driver = new ChromeDriver(options);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
				}
				
				if (edbrowser.equals("Edge")) {
					WebDriverManager.edgedriver().setup();
					// Handle Browser notifications
					EdgeOptions options = new EdgeOptions();
					// Allow Notifications
					options.addArguments("--disable-notifications");
					// Launch the browser (Edge)
					driver = new EdgeDriver(options);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
				}
				
				driver.get(url);
				driver.manage().window().maximize();
				//Login by using the given username and pwd
				driver.findElement(By.id("username")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys(password);
				driver.findElement(By.id("Login")).click();
						
				
				// explicit wait 
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				WebElement waffle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
				wait.until(ExpectedConditions.elementToBeClickable(waffle));

				//Click on the App Launcher (dots)
				waffle.click();

				//Find element for mouse action
				WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));

				//Control move to mouse action
				builder = new Actions(driver);

				//Mouse over
				builder.moveToElement(viewAll).click().perform();
			
	}
	
	@AfterMethod
	public void postCondition() {
		
		//Get the Title of Resulting Page
		System.out.println(driver.getTitle());
		//Close the browser
		driver.close();
	}
	
	@DataProvider (name = "TC001")
	public String [][] fetchData() throws IOException{
		
		data = ReadSalesForceData.readSalesData(excelFileName);
		chbrowser = "Chrome";
		return data;
		
	}
	
	@DataProvider (name = "TC002")
	public String [][] fetchData1() throws IOException{
		
		data1 = ReadSalesForceData.readSalesSaluationData(excelFileName);
		edbrowser = "Edge";
		return data1;
		
	}
}
