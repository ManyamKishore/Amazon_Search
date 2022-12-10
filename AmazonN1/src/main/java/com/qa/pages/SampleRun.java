package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleRun {
  WebDriver driver;
  List<String> listd=new ArrayList<String>();
  @FindBy(xpath = "//div[@class='_37M3Pb']//div[@class='xtXmba']")
	public static List<WebElement> dropopt1;
  
  @FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	public static WebElement flipkartSearchBox1;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	public static WebElement cancel1;
	
  
    @Test
	public void sample() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		PageFactory.initElements(driver, SampleRun.class);
		cancel1.click();
		Thread.sleep(3000);
		for(int i=0;i<dropopt1.size();i++){
			listd.add(dropopt1.get(i).getText());
			for(WebElement in:dropopt1) {
				if(dropopt1.get(i).getText().equalsIgnoreCase("Grocery")) {
					in.click();
					break;
				}
			}
		}
		Thread.sleep(3000);
		flipkartSearchBox1.sendKeys("mobile"+Keys.ENTER);
		System.out.println("list is: "+ listd);
	
		
	}
}
