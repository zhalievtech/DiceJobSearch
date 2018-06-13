package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();	

String url = "https://dice.com";
String keyword = "Selenium Automation";		
String location = "Chicago";
String actualTitle = driver.getTitle();
String expectedTitle = "Job Search for Technology Professionals | Dice.com ";
//
//	if(actualTitle.equals(expectedTitle)) {
//		System.out.println("Step PASS. Dice homepage successfully loaded");
//	}else {
//		System.out.println("Step FAIL. Dice homepage unsuccessfully loaded");
//		throw new RuntimeException("Step FAIL. Dice homepage unsuccessfully loaded");
//	}
		
		
		driver.manage().window().fullscreen();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		driver.findElement(By.id("search-field-location")).clear();
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count = driver.findElement(By.id("posiCountId")).getText();
		//ensure count is more than 0
		int countResult = Integer.parseInt(count);
		
		if(countResult > 0) {
			System.out.println("Keyword "+ keyword+ " search returned "+countResult+" result in "+ location);
		}else {
			System.out.println("Keyword "+ keyword+ " search returned "+countResult+" result in "+ location);
		}
		
		Thread.sleep(5000);
		driver.close();
		
		
	}
}
