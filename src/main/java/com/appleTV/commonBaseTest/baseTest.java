package com.appleTV.commonBaseTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import com.amazon.excelRead.excelRead;
import com.appleTV.Utilities.GenericMethods;
import com.appleTV.Utilities.constants;


import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest 
{
	WebDriver driver;
	GenericMethods GM = new GenericMethods();
	excelRead ER = new excelRead();
	
  @BeforeClass
  public void launchBrowser() throws IOException
  {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(constants.implicitWait,TimeUnit.SECONDS);
	  
	  String URL = GM.getProperties(constants.confingFileName,"URL");
	  driver.get(URL);
	  driver.manage().window().maximize();
	}
  @Test
  public void scenario() throws IOException, Exception 
  {
	  //to click on TV & Home
	  String tvHome = ER.read(constants.excelPath,"TVHOME");
	  GM.click(driver, tvHome);
	  Thread.sleep(constants.threadWait);
	  
	  //to click on Apple TV App
	  String appleTVapp = ER.read(constants.excelPath,"appleTVapp");
	  GM.click(driver, appleTVapp);
	  Thread.sleep(constants.threadWait);
	  
	  //to scroll to buy
	  GM.scroll(driver, 10500);
	  Thread.sleep(constants.threadWait);
	  
	  //to click on Buy
	  String Buy = ER.read(constants.excelPath,"Buy");
	  GM.click(driver, Buy);
	  Thread.sleep(constants.threadWait);
	  
	  String WifiEthernet = ER.read(constants.excelPath,"Wifi+Ethernet");
	  GM.click(driver, WifiEthernet);
	  Thread.sleep(constants.threadWait);
	  
	  GM.scroll(driver, 500);
	  Thread.sleep(constants.threadWait);
	  
	  String GetDeliveryDates = ER.read(constants.excelPath,"GetDeliveryDates");
	  GM.click(driver, GetDeliveryDates);
	  Thread.sleep(constants.threadWait);
	  
	  // to enter postal code
	  String postalCode = ER.read(constants.excelPath,"PostalCode");
	  GM.click(driver, postalCode);
	  String pincode = ER.read(constants.testDataPath, "Postal Code");
	  GM.sendKeys(driver, postalCode, pincode);
	  Thread.sleep(constants.threadWait);
	  
	  // to click on View Options button
	  String ViewOptions = ER.read(constants.excelPath,"ViewOptions");
	  GM.click(driver, ViewOptions);
	  Thread.sleep(constants.threadWait);
	  
	  //to close Delivery Options tab
	  String closeTab = ER.read(constants.excelPath,"CloseTab");
	  GM.click(driver, closeTab);
	  Thread.sleep(constants.threadWait);
	  
	  //to click on Add To Bag	  
	  String AddToBag = ER.read(constants.excelPath,"AddToBag");
	  GM.click(driver, AddToBag);
	  Thread.sleep(constants.threadWait);
	  
	  // to click on Review Bag
	  String ReviewBag = ER.read(constants.excelPath,"ReviewBag");
	  GM.click(driver, ReviewBag);
	  Thread.sleep(constants.threadWait);
  }
  
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}

