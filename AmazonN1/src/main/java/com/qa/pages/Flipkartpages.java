package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flipkartpages {


	@FindBy(xpath = "//div[@class='_37M3Pb']//div[@class='xtXmba']")
	public static List<WebElement> dropoptions;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	public static WebElement flipkartSearchBox;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	public static WebElement cancel;
	
}
