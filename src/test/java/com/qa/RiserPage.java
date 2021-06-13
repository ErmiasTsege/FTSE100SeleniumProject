package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RiserPage {

	// public final static String URL =
	// "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers";

	private WebDriver driver;
	public WebElement webelements;

	// 1
	public RiserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public static String getUrl() {
//		return URL;
//	}

	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[2]/a/strong")
	private WebElement searchRISER;

	public void riser() {
		searchRISER.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
