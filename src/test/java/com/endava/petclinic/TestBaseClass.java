package com.endava.petclinic;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBaseClass {

	protected WebDriver driver;
	protected Faker faker = new Faker();

	@BeforeEach
	public void setUpDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
	}

	@AfterEach
	public void tearDownDriver() throws Exception {
		Thread.sleep( 2000 );
		takeSnapShot( driver, "C://users/astoica/Desktop/ss.jpeg" );
		driver.quit();
	}

	public void takeSnapShot( WebDriver webdriver, String fileWithPath ) throws Exception {
		TakesScreenshot scrShot = ( (TakesScreenshot) webdriver );
		File SrcFile = scrShot.getScreenshotAs( OutputType.FILE );
		File DestFile = new File( fileWithPath );
		FileUtils.copyFile( SrcFile, DestFile );
	}

}
