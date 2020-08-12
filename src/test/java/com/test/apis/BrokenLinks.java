package com.test.apis;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
		
		public static WebDriver driver;

		public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Chrome browser launched");
			driver.get("https://www.facebook.com/");
			System.out.println("web page launched");
		
		//get the list of all links and image
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img"))); 
		
		System.out.println("All links size is: -->"+allLinks.size());

		// created a array list to store active list
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		
		//get the list of all active links and image- doesn't have any href attribute
		for(int i=0; i<allLinks.size();i++) {
			
		//	System.out.println(allLinks.get(i).getAttribute("href"));
			
			if(allLinks.get(i).getAttribute("href")!=null) {
				activeLinks.add(allLinks.get(i));
			}
		}
		
		System.out.println("Active list size is: -->"+activeLinks.size());
		
		// checking the connection for broken URL
		for(int j=0; j<activeLinks.size();j++) {
		HttpURLConnection connection=(HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String response=connection.getResponseMessage();
		connection.disconnect();
		
		//System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+response);
		if(response.equalsIgnoreCase("Not Found")) {
			System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+response);

		}
		
		}
	
		driver.quit();
		
	}

}
