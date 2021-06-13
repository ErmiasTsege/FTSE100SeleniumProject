package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FallerPage {

//	public final static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100/fallers";

	private WebDriver driver;
	private WebElement fallerweb;

	// 1
	public FallerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public static String getUrl() {
//		return URL;
//	}

	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[3]/a/strong")
	private WebElement searchFAlLER;

	public void faller() {
		searchFAlLER.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

}
