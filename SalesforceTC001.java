package independencyDayMarathonScenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTC001 extends BaseClass {

	@BeforeTest
	public void setup() {

		excelFileName = "SalesForceQuestions";
	}

	@Test (dataProvider = "TC001")
	public void tc001(String Questions, String Details) throws InterruptedException {

		//length = data.length;

		//enter search option as "Content" in search box
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).click();
		driver.findElement(By.xpath("//one-app-launcher-search-bar[@class='searchBar']")).sendKeys("Content",Keys.TAB);
		driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Content']")).click();
		WebElement element = driver.findElement(By.xpath("//span[text()=\"Chatter\"]"));
		driver.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[@role=\"textbox\"]")).click();
		driver.findElement(By.xpath("//textarea[@role=\"textbox\"]")).sendKeys(Questions);
		driver.findElement(By.xpath("//div[@role='textbox']")).click();
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(Details);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		Thread.sleep(2000);
		String str = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		if (str.contains(Questions)) {
			System.out.println("Quetions posted successfully");

		}

	}
}

