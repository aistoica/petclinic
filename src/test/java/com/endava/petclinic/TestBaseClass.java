package com.endava.petclinic;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.endava.petclinic.data.DataGeneration;
import com.endava.petclinic.driver.DriverManager;
import com.github.javafaker.Faker;

import java.io.File;

public class TestBaseClass {

	protected WebDriver driver;
	protected Faker faker = new Faker();
	protected DataGeneration dataGeneration = new DataGeneration();

	@BeforeEach
	public void setUpDriver() {
		driver = DriverManager.getWebDriver();
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
