package org.vertex.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class InvokeBrowser {
	WebDriver driver;
	ChromeOptions chromeOptions = new ChromeOptions();
//	SendEmail sendEmail =new SendEmail();

	
	@AfterTest
	public void tearDown() {
		//driver.close();
	}
	@BeforeTest
	public void init() {
		//System.setProperty("webdriver.chrome.driver", "../Sel_Database/Drivers/chromedriver.exe");
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		//chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN11);
		try {
			driver=new ChromeDriver();
			
			//driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
		}//MalformedURLException
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability("browserVersion", "74");
				chromeOptions.setCapability("platformName", "Windows 10");
				//driver = new RemoteWebDriver(new URL("http://www.myexamplebrowserstack.com"), chromeOptions);
			//	driver.get("http://www.google.com");
				//driver.quit();
												
						
						
	}
	@Test
	public void verifyUserLogin() throws InterruptedException, AWTException, MalformedURLException, EmailException {
		
		
		  String userName ="Karthik.K";
		  String password ="Vertex@1";
		 String domain ="intranet.vertexcs.com/SitePages/downloads.aspx?ctype=Downloads"; 
		  //String url= "http://"+userName+":"+password+"@"+domain;
		  String url ="https://www.google.com/";
		  //System.out.println("Application is "+url);
		 //String url = "https://mail.google.com/";
		driver.get(url);
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		
        String s = driver.getTitle();
//		Thread.sleep(2000);
//		Robot rb = new Robot();
//		rb.keyPress(0);
//		
		System.out.println("Page Tiltle is "+ s);
		
		//System.out.println("Page Tiltle is "+ s);
		
		
		//sendEmail.emailsend();
		//sendEmail.sendEmail1();
		
		
		/*
		 * Email email = new SimpleEmail(); email.setHostName("smtp.gmail.com");
		 * email.setSmtpPort(465); email.setAuthenticator(new
		 * DefaultAuthenticator("karthik.sample27@gmail.com", "Testing@123"));
		 * email.setSSLOnConnect(true); email.setFrom("karthik.sample27@gmail.com");
		 * email.setSubject("TestMail"); email.setMsg("This is a test mail ... :-)");
		 * email.addTo("karthik.sample27@gmail.com"); email.send();
		 * 
		 * System.out.println("Email Sent");
		 * 
		 * 
		 */		
		/*
		 * WebElement element = driver.findElement(By.xpath(s));
		 * ((RemoteWebElement)element).setFileDetector(new LocalFileDetector());
		 * element.sendKeys(folderPath);
		 */
	  
	}
	

}
