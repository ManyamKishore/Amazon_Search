package com.qa.testscripts;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.pages.Flipkartpages;
import com.qa.utility.ExcelUtility;

public class FlipkartSearch extends FlipTestbase{
 
	@DataProvider(name="getdata")
	public String[][] getData() throws IOException {
		
		String xFile="C:\\Users\\USER\\Downloads\\Flipdata.xlsx";
		String xSheet="Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		System.out.println("rows = "+rowCount);
		System.out.println("cells = "+cellCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
}
	@Test(dataProvider = "getdata")
	public void getTest(String catagory, String items ) throws IOException, InterruptedException {
	PageFactory.initElements(driver, Flipkartpages.class);
	
	Flipkartpages.cancel.click();
	Thread.sleep(3000);
	for(int i=0;i<Flipkartpages.dropoptions.size();i++){
		for(WebElement in:Flipkartpages.dropoptions) {
			if(Flipkartpages.dropoptions.get(i).getText().equalsIgnoreCase(catagory)) {
				in.click();
				break;
			}
		}
	}
	Thread.sleep(3000);
	Flipkartpages.flipkartSearchBox.sendKeys(items+Keys.ENTER);
	driver.navigate().to("https://www.flipkart.com/");
}
}
