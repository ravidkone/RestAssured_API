package com.test.apis;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gojek {

	public static String browser = "chrome";
	// public static String browser="ff";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

//		if(browser=="chrome") {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Chrome browser launched");

//		}else 
//		{
//			WebDriverManager.firefoxdriver().setup();
//			WebDriver driver=new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			System.out.println("Firefox browser launched");
//
//		}

		driver.get("https://demo.midtrans.com/");
		System.out.println("web page launched");
	
		String title = driver.getTitle();
		System.out.println("Beowser title is:" + title);

		int size = driver.findElements(By.tagName("iframe")).size();
		// prints the total number of frames inside outer frame
		System.out.println("Total Frames --" + size);

		driver.findElement(By.xpath("//a[@class='btn buy']")).click();
		driver.findElement(By.xpath("//div[@class='cart-checkout']")).click();

//		Set<String> windows=driver.getWindowHandles();
//		Iterator<String> it= windows.iterator();
//		System.out.println(it.next());
		System.out.println("******");
//		System.out.println(it.next());

		try {
			driver.switchTo().frame(0);
			// driver.switchTo().frame("popup_1592038955727");
			// driver.switchTo().frame("//iframe[@id='snap-midtrans']");
			System.out.println("swicthed to iframe");
		} catch (Exception e) {
			System.out.println("couldn't able to find frame");
		}

		Thread.sleep(1000);

		try {
		// driver.findElement(By.xpath("//div[@id='application']/div[1]/a"));
		driver.findElement(By.xpath("//*[@id=\"application\"]/div[1]/a")).click();
		Thread.sleep(1000);
		int size1 = driver.findElements(By.tagName("iframe")).size();
		// prints the total number of frames inside outer frame
		System.out.println("Total Frames --" + size1);

		driver.findElement(By.xpath("//a[@href='#/credit-card']")).click();
		driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("4811 1111 1111 1114");
		driver.findElement(By.xpath("//input[@placeholder='MM / YY']")).sendKeys("0620");
		driver.findElement(By.xpath("//input[@placeholder='123']")).sendKeys("123");
		driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("112233");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-sm btn-success']")).click();

		// driver.switchTo().frame(0);
		driver.switchTo().defaultContent();
		// String
		// text1=driver.findElement(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div/div/div/div[2]")).getText();

		String text2 = driver.findElement(By.xpath("//span[text()='Thank you for your purchase.']")).getText();

		System.out.println(text2);

		Thread.sleep(3000);

	}catch (Exception e) {
		System.out.println("couldn't able to find element");		
	}
		Thread.sleep(5000);
		driver.close();
		System.out.println("browser closed");
	}

}
