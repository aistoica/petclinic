package com.endava.petclinic.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class DriverManager {

	public static WebDriver getWebDriver() {
		String browser = System.getProperty( "browser" );

		if ( browser.equals( "chrome" ) ) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );

			return driver;
		} else if ( browser.equals( "firefox" ) ) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );

			return driver;
		} else if ( browser.equals( "edge" ) ) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );

			return driver;
		} else {
			throw new RuntimeException( "Can't handle browser " + browser );
		}
	}
}
