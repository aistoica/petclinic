package com.endava.petclinic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.petclinic.pageObjects.AddOwnerPage;
import com.endava.petclinic.pageObjects.OwnerListPage;

public class AddOwnerTest extends TestBaseClass {

	@Test
	public void shouldAddOwner() throws InterruptedException {

		//GIVEN
		AddOwnerPage addOwnerPage = new AddOwnerPage( driver );
		addOwnerPage.load();

		//WHEN
		OwnerListPage ownerListPage = addOwnerPage.addNewOwner( faker.name().firstName(), faker.name().lastName(),
				faker.address().streetAddress(), faker.address().city(), faker.number().digits( 10 ) );

		//THEN
		assertThat( driver.getCurrentUrl() ).endsWith( "/owners" );

	}

	@Test
	public void shouldNotAddOwnerGivenInvalidPhone() throws InterruptedException {

		//GIVEN
		AddOwnerPage addOwnerPage = new AddOwnerPage( driver );
		addOwnerPage.load();

		//WHEN
		addOwnerPage.addNewOwner( faker.name().firstName(), faker.name().lastName(), faker.address().streetAddress(), faker.address().city(),
				faker.lorem().characters( 5 ) + faker.number().digits( 5 ) );

		//THEN
		assertThat( addOwnerPage.isSubmitButtonEnabled() ).isFalse();
		//TODO: add assert for error message

		Thread.sleep( 1000 );
		assertThat( driver.getCurrentUrl() ).endsWith( addOwnerPage.getBaseUrl() );
	}
}
