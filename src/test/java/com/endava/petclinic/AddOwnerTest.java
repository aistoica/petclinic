package com.endava.petclinic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.pageObjects.AddOwnerPage;
import com.endava.petclinic.pageObjects.OwnerListPage;

public class AddOwnerTest extends TestBaseClass {

	@Test
	public void shouldAddOwner() throws InterruptedException {

		//GIVEN
		AddOwnerPage addOwnerPage = new AddOwnerPage( driver );
		addOwnerPage.load();

		Owner owner = dataGeneration.generateRandomOwner();

		//WHEN
		OwnerListPage ownerListPage = addOwnerPage.addNewOwner( owner );

		//THEN
		Owner actualOwner = ownerListPage.getOwnerFromTable( owner.getTelephone() );
		assertThat( actualOwner ).isEqualTo( owner );

	}

	@Test
	public void shouldNotAddOwnerGivenInvalidPhone() throws InterruptedException {

		//GIVEN
		AddOwnerPage addOwnerPage = new AddOwnerPage( driver );
		addOwnerPage.load();

		Owner owner = dataGeneration.generateRandomOwner();
		owner.setTelephone( "111AAA" );

		//WHEN
		addOwnerPage.addNewOwner( owner );

		//THEN
		assertThat( addOwnerPage.isSubmitButtonEnabled() ).isFalse();
		//TODO: add assert for error message

		Thread.sleep( 1000 );
		assertThat( driver.getCurrentUrl() ).endsWith( addOwnerPage.getBaseUrl() );
	}
}
