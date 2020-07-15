package com.endava.petclinic.data;

import com.endava.petclinic.model.Owner;
import com.github.javafaker.Faker;

public class DataGeneration {

	private Faker faker = new Faker();

	public Owner generateRandomOwner() {
		Owner owner = new Owner();
		owner.setFirstName( faker.name().firstName() );
		owner.setLastName( faker.name().lastName() );
		owner.setAddress( faker.address().streetAddress() );
		owner.setCity( faker.address().city() );
		owner.setTelephone( faker.number().digits( 10 ) );

		return owner;
	}
}
