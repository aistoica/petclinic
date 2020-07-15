package com.endava.petclinic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.pageObjects.OwnerListPage;

public class OwnerListTest extends TestBaseClass {

	@Test
	public void shouldVerifyOwnerListGivenExistingOwner() {

		//GIVEN
		OwnerListPage ownerListPage = new OwnerListPage( driver );
		ownerListPage.load();

		//WHEN
		Owner ownerDetails = ownerListPage.getOwnerFromTable( "6085551023" );

		//THEN
		assertThat( ownerDetails.getFirstName() ).isEqualTo( "George" );
		assertThat( ownerDetails.getLastName() ).isEqualTo( "Franklin" );
		assertThat( ownerDetails.getAddress() ).isEqualTo( "110 W. Liberty St." );
		assertThat( ownerDetails.getCity() ).isEqualTo( "Madison" );
		assertThat( ownerDetails.getTelephone() ).isEqualTo( "6085551023" );
//		assertThat( ownerDetails.get( 4 ) ).isEqualTo( "Leo" );
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
