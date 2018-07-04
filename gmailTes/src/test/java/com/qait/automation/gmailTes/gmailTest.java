package com.qait.automation.gmailTes;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class gmailTest {
	WebDriver driver;
	gmailFunc obj;

	@BeforeClass
	public void launchURL() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rishabh.jain1\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
		obj = new gmailFunc(driver);
		
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void firstCase() {
		obj.login();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void secondCase() {
		obj.countUnreadMails();
	}
	@Test(priority=3)
	public void thirdCase() {
		obj.logout();
	}
	@AfterClass
	public void closeUrl() {
		driver.quit();
	}
}
