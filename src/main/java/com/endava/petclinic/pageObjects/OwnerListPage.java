package com.endava.petclinic.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.endava.petclinic.EnvReader;
import com.endava.petclinic.model.Owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerListPage {

	private static final String baseUrl = EnvReader.getBaseUrl() + "owners";

	private WebDriver driver;

	By row = By.cssSelector( "table tbody tr" );
	By nameCell = By.cssSelector( "td:nth-child(1)" );
	By addressCell = By.cssSelector( "td:nth-child(2)" );
	By cityCell = By.cssSelector( "td:nth-child(3)" );
	By phoneCell = By.cssSelector( "td:nth-child(4)" );

	public OwnerListPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load() {
		driver.get( baseUrl );
	}

	public Owner getOwnerFromTable( String telephone ) {

		Owner owner = new Owner();

		// search for the row with the telephone
		List<WebElement> rows = driver.findElements( row );
		for ( WebElement ownerRow : rows ) {
			if ( ownerRow.findElement( phoneCell ).getText().equals( telephone ) ) {

				String name = ownerRow.findElement( nameCell ).getText();

				owner.setFirstName( name.split( " ", 2 )[0] );
				owner.setLastName( name.split( " ", 2 )[1] );
				owner.setAddress( ownerRow.findElement( addressCell ).getText() );
				owner.setCity( ownerRow.findElement( cityCell ).getText() );
				owner.setTelephone( ownerRow.findElement( phoneCell ).getText() );

				break;
			}
		}

		return owner;
	}
}
