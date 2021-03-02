package com.test.sirisha.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebpageHelper {
	
	public static WebElement waitforElement(WebDriver driver, WebElement element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(element));
		return myDynamicElement;
	}
	
	public static WebElement findIFrameByXpath(WebDriver driver, String xpath) {
		int size = driver.findElements(By.tagName("iframe")).size();
	    for(int frame_idx=0; frame_idx<=size; frame_idx++) {
			driver.switchTo().frame(frame_idx);
			int total_xpaths = driver.findElements(By.xpath("html/body/a/img")).size();
			
			if (total_xpaths == 1) {
				return  driver.findElement(By.xpath("html/body/a/img"));
			}
			else if (total_xpaths > 1){
//				This should not happen .. Ambiguity
				driver.findElements(By.xpath("html/body/a/img")).get(0);
			}
	    }
	    return null;
	}
	
	public static WebElement findIFrameByXpathNested(WebDriver driver, String xpath, int depth) {
		if (depth == -1) {
			return null;
		}
		int size = driver.findElements(By.tagName("iframe")).size();
	    for(int frame_idx=0; frame_idx<=size; frame_idx++) {
			driver.switchTo().frame(frame_idx);
			int total_xpaths = driver.findElements(By.xpath("html/body/a/img")).size();

			if (total_xpaths == 1) {
				return  driver.findElement(By.xpath("html/body/a/img"));
			}
			else if (total_xpaths > 1){
//				This should not happen .. Ambiguity
				driver.findElements(By.xpath("html/body/a/img")).get(0);
			}
			else {
				 findIFrameByXpathNested(driver, xpath, --depth);
			}
	    }
	    
	    return null;
	}
}
