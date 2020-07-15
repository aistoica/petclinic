package com.endava.petclinic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OwnerListTest extends TestBaseClass {

	private String baseUrl = EnvReader.getBaseUrl() + "owners";

	@BeforeEach
	public void openUrl() {
		driver.get( baseUrl );
	}

	@Test
	public void shouldVerifyOwnerListGivenExistingOwner() {

		//GIVEN

		//WHEN
		WebDriverWait wait = new WebDriverWait( driver, 15 );
		List<WebElement> firstRowCells = wait.until( ExpectedConditions.presenceOfNestedElementsLocatedBy( By.cssSelector( "table" ),
				By.cssSelector( "tbody tr:first-child td" ) ) );

		//THEN
		assertThat( firstRowCells.get( 0 ).getText() ).isEqualTo( "George Franklin" );
		assertThat( firstRowCells.get( 0 ).findElement( By.cssSelector( "a" ) ).getAttribute( "href" ) ).isEqualTo( baseUrl + "/1" );
		assertThat( firstRowCells.get( 1 ).getText() ).isEqualTo( "110 W. Liberty St." );
		assertThat( firstRowCells.get( 2 ).getText() ).isEqualTo( "Madison" );
		assertThat( firstRowCells.get( 3 ).getText() ).isEqualTo( "6085551023" );
		assertThat( firstRowCells.get( 4 ).getText() ).isEqualTo( "Leo" );
	}

	@Test
	public void shouldDisplayAddOwnerButton() {

		//GIVEN

		//WHEN
		WebElement button = driver.findElement( By.cssSelector( "button" ) );

		//THEN
		assertThat( button.isEnabled() ).isTrue();
		assertThat( button.getText() ).isEqualTo( "Add Owner" );
	}

}
