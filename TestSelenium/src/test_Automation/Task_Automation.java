package test_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Task_Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver(); //Open the browser
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Waiting time global
		driver.get("https://www.jakmall.com/"); // Visit link
		driver.findElement(By.id("onesignal-slidedown-cancel-button")).click(); // Click permission notification
		driver.findElement(By.linkText("Login")).click(); //Click Login
		
		//Login
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rizkihalo@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test123456.");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		//Add to Chart
		driver.findElement(By.cssSelector("input[class='header__search__input input__autocomplete__hide']")).sendKeys("Iphone");
		driver.findElement(By.cssSelector("button[class='header__search__submit']")).click();
		driver.findElement(By.cssSelector("div[id='pi-6130201698167'] div[class='pi__header'] a")).click();
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(By.xpath("//a[@class='button button--cta-invert button--full']")).click();
		
		
		//Verification Chart
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='flex--simple'] a[class='link link--cta']")).click();
		js.executeScript("window.scrollBy(0, 350)");
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class='marr--md']")).getText(), "Total Belanja (1) :");
		
	}

}
