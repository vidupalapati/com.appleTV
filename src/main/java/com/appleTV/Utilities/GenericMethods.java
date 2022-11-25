package com.appleTV.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class GenericMethods 
{
	public String getProperties(String fileName,String propertyName) throws IOException
	{
		Properties loadfile = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		loadfile.load(fis);
		String str = loadfile.getProperty(propertyName);
		return str;
	}
	
	public void click(WebDriver driver,String Element)
	{
		driver.findElement(By.xpath(Element)).click();
	}
	
	public void scroll(WebDriver driver,long offset)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,"+ offset +")");
	}
	
	public void sendKeys(WebDriver driver,String Element,String Text)
	{
		driver.findElement(By.xpath(Element)).sendKeys(Text);
	}
}
