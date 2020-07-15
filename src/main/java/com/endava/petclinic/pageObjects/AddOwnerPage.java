package com.endava.petclinic.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.petclinic.EnvReader;

public class AddOwnerPage {

	private static final String baseUrl = EnvReader.getBaseUrl() + "owners/add";

	private WebDriver driver;

	private By firstNameInput = By.id( "firstName" );
	private By lastNameInput = By.id( "lastName" );
	private By addressInput = By.id( "address" );
	private By cityInput = By.id( "city" );
	private By telephoneInput = By.id( "telephone" );
	private By submitButton = By.cssSelector( "button[type='submit']" );

	public AddOwnerPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load() {
		driver.get( baseUrl );
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public OwnerListPage addNewOwner( String firstName, String lastName, String address, String city, String telephone ) {
		WebDriverWait wait = new WebDriverWait( driver, 10 );
		wait.until( ExpectedConditions.visibilityOfElementLocated( firstNameInput ) ).sendKeys( firstName );
		wait.until( ExpectedConditions.visibilityOfElementLocated( lastNameInput ) ).sendKeys( lastName );
		wait.until( ExpectedConditions.visibilityOfElementLocated( addressInput ) ).sendKeys( address );
		wait.until( ExpectedConditions.visibilityOfElementLocated( cityInput ) ).sendKeys( city );
		wait.until( ExpectedConditions.visibilityOfElementLocated( telephoneInput ) ).sendKeys( telephone );

		boolean submitButtonEnabled = isSubmitButtonEnabled();
		wait.until( ExpectedConditions.visibilityOfElementLocated( submitButton ) ).click();

		if( submitButtonEnabled ) {
			wait.until( ExpectedConditions.urlToBe( EnvReader.getBaseUrl() + "owners" ) );
		}

		return new OwnerListPage( driver );
	}

	public boolean isSubmitButtonEnabled() {
		return driver.findElement( submitButton ).isEnabled();
	}
}
