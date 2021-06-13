package com.qa;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FTSEsiteTesting {
	private static WebDriver driver;
	static String URL = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";

	@BeforeClass

	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver(Config.chromecfg().setHeadless(false));
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)).pageLoadTimeout(Duration.ofSeconds(10));

	}

	@Before
	public void setup() {
		try {

			driver.get(URL);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)).pageLoadTimeout(Duration.ofSeconds(10));

		} catch (TimeoutException e) {
			e.printStackTrace();
			System.out.println("no no no no");
		}
	}

	@Test
	public void RiserandFallerSearch() throws InterruptedException {

		System.out.println(driver.getCurrentUrl());
		RiserPage riserpage = new RiserPage(driver);

		System.out.println(riserpage.getDriver().getCurrentUrl());
		Thread.sleep(20000);

		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(1000))
				.ignoring(Exception.class).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id=\"view-constituents\"]/ul/li[2]/a")));

		riserpage.riser();

		Thread.sleep(15000);
		FallerPage fallerpage = new FallerPage(driver);

		Thread.sleep(20000);
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(500))
				.ignoring(Exception.class).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id=\"view-constituents\"]/ul/li[3]/a")));

		fallerpage.faller();

		Thread.sleep(15000);

	}

	@After
	public void tearDown() {
		driver.quit();

	}

}
