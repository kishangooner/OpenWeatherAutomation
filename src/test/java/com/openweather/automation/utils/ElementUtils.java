package com.openweather.automation.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtils {
	
	Logger log = Logger.getLogger(ElementUtils.class.getName());
	private final WebDriver driver;
	private WebDriverWait wait ;
	
	public ElementUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	/**
	 * @param expectedElements
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementsDisplayedInPage(List<WebElement> expectedElements) throws Exception {
		boolean status = false;
		try {
			int listSize = expectedElements.size();
			List<WebElement> unmatchedElements = new ArrayList<WebElement>();
			wait= new WebDriverWait(driver, 10);
			int count = 0;
			
			for (WebElement element: expectedElements)
			{
				if ( wait.until(ExpectedConditions.visibilityOf(element)) != null) {
					count++;
				} else {
					unmatchedElements.add(element);
				}
			}
			
			if (count == listSize) {
				status = true;
				log.info("All elements checked on this page:: " + expectedElements);
			} else {
				log.info("Missing element on this page:: " + unmatchedElements);
			}

		} catch (Exception e) {
			return status;
		}

		return status;
	}

	
	/**
	 * @param element
	 * @return
	 */
	public boolean verifyElementDisplayedOnPage(WebElement element)
	{
		try {
			wait= new WebDriverWait(driver, 10);
			if (wait.until(ExpectedConditions.visibilityOf(element)) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
}
