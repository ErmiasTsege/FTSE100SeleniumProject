package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage {

	public final static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";

	private WebDriver driver;
	public WebElement webelements;

	// 1
	public Landingpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getUrl() {
		return URL;
	}

//	@FindBy(xpath = "//*[@id=\"content_div_40583\"]/ul/li[3]/a")
//	private WebElement searchRISER;
//
//	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[2]/a")
//	private WebElement searchFAlLER;
//	
	@FindBy(xpath = "//strong[contains(text(),'RISERS')]")
	private WebElement searchRISER;
	///
	
	@FindBy(xpath = "//strong[contains(text(),'FALLERS')]")
	private WebElement searchFAlLER;
	
	public void riser() {
		searchRISER.click();
	}
	
	public void faller() {
		searchFAlLER.click();
	}
	public WebDriver getDriver() {
		return driver;
	}

}
