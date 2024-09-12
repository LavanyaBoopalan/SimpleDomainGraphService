package com.simple.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.simple.dgs.model.Manufacturer;
import com.simple.dgs.model.input.ManufacturerInput;
import com.simple.dgs.repository.ManufacturerRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ManufacturerMutation {
	
	 private final ManufacturerRepository manufacturerRepository;

		@DgsData(parentType = "MutationResolver", field = "createManufacturer")
		public Manufacturer createManufacturer(@InputArgument("manufacturer") ManufacturerInput manufacturer) {
			return manufacturerRepository.save(Manufacturer.builder().name(manufacturer.getName()).website(manufacturer.getWebsite()).phone(manufacturer.getPhone())
					.street(manufacturer.getStreet()).city(manufacturer.getCity()).state(manufacturer.getState()).country(manufacturer.getCountry()).build());
		}
}

