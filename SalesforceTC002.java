package independencyDayMarathonScenarios;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTC002 extends BaseClass {
	

	@BeforeTest
	public void setup() {
		
		excelFileName = "SalesForceSaluation";
	}
	
	
	@Test (dataProvider = "TC002")
	public void tc002(String salutation, String name) throws InterruptedException {
			
	 		
		//enter search option as "Individuals" in search box
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).click();
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys("Individuals",Keys.TAB);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Individuals']")).click();
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//span[text()='Salutation']/following::div")).click();
		String s = salutation;
		driver.findElement(By.xpath("(//div[@class='select-options'])[1]/following::a[@title='"+s+"']")).click();
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[1]")).click();
		driver.findElement(By.xpath("//span[text()='Last Name']/following::input[1]")).sendKeys(name);
		String cusName = driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input'])[2]/input")).getAttribute("value");	
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);
		//Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Mouse over
		builder.moveToElement(driver.findElement(By.xpath("//button[text()='View All']"))).click().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).click();
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys("Customers",Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Customers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@title='New'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']/input")).click();
		driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']/input")).sendKeys(cusName);
		String name1 = driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).getText();
		if (cusName.equals(name1)) {
			System.out.println(name1 + " Individual name listed in the dropdown");	
		}

	}
}

		
		



