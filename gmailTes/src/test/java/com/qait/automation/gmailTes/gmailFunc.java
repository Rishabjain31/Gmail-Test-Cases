package com.qait.automation.gmailTes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class gmailFunc {
	WebDriver driver;

	public gmailFunc(WebDriver driver) {
		this.driver = driver;
	}

	public void login() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("identifierId")).sendKeys("coolrishabh.jain420@gmail.com");
		//driver.findElement(By.id("identifierId")).click();
		driver.findElement(By.cssSelector("div[class='qhFLie'] div[id='identifierNext']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='Xb9hP']//child::input[@type='password']")).sendKeys("rishabhjain");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElement(By.cssSelector("div[class='qhFLie']
		// div[id='passwordNext']")).click();
		js.executeScript("document.querySelector(\"div[class=qhFLie] div[id=passwordNext]\").click()");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.cssSelector("div[class='gb_Sc'] svg[class='gb_he']")).click();
//		
//		driver.findElement(By.cssSelector("div[class='gb_ga gb_fa gb_za gb_g gb_ha gb_ma'] a[id='gb23'] span[class='gb_3']")).click();
//		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	
	public void firstUnreadMail() {
		List<WebElement> u_mails = driver.findElements(By.cssSelector("div[class=UI] tr[class='zA zE']"));
		System.out.println(u_mails.size());
		u_mails.get(0).click();
}
	public void composeMail() {
		driver.findElement(By.className("T-I J-J5-Ji T-I-KE L3")).click();
		driver.findElement(By.className("wO nr l1")).sendKeys("coolrishabh.jain420@gmail.com");
		driver.findElement(By.className("aoD az6")).sendKeys("Mail");
		driver.findElement(By.className("Am Al editable LW-avf")).sendKeys("This is a trial mail.");
		driver.findElement(By.className("T-I J-J5-Ji aoO T-I-atl L3 T-I-Zf-aw2")).click();
	}
	public void countUnreadMails() {
		String str=driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']")).getAttribute("title");
		System.out.println(str);
		System.out.println(str.substring(7, 12));
		firstUnreadMail();
		driver.navigate().to(driver.getCurrentUrl());  
		driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']")).click();
		String str1=driver.findElement(By.cssSelector("div[class='TN bzz aHS-bnt'] a[class='J-Ke n0']")).getAttribute("title");
		System.out.println("Mails after first unread mail was read in" +str1);
		System.out.println(str1.substring(7, 12));
	}
	public void logout() {
		driver.findElement(By.cssSelector("span[class='gb_db gbii']")).click();
		driver.findElement(By.cssSelector("a[id='gb_71']")).click();
		
	}
}

