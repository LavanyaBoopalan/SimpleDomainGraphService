package com.simple.dgs.fetcher.query;

import java.util.List;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.simple.dgs.context.CustomContextBuilder;
import com.simple.dgs.model.Manufacturer;
import com.simple.dgs.repository.ManufacturerRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class ManufacturerDataFetcher {

	private final ManufacturerRepository manufacturerRepository;
	private final CustomContextBuilder contextBuilder;

	@DgsData(parentType = "QueryResolver", field = "manufacturers")
	public Iterable<Manufacturer> findAll(DgsDataFetchingEnvironment dfe) {
		var manufacturers = (List<Manufacturer>) manufacturerRepository.findAll();
//	        contextBuilder.customContext(null, manufacturers, null).build();
		return manufacturers;
	}

	@DgsData(parentType = "QueryResolver", field = "manufacturer")
	public Manufacturer findById(@InputArgument("id") String id, DgsDataFetchingEnvironment dfe) {
		return manufacturerRepository.findById(Long.parseLong(id)).orElseThrow(DgsEntityNotFoundException::new);
		/*
		 * CustomContext customContext = DgsContext.getCustomContext(dfe); var
		 * manufacturers = customContext.getManufacturers(); if
		 * (CollectionUtils.isEmpty(manufacturers)) { return
		 * manufacturerRepository.findById(Long.parseLong(id)).orElseThrow(
		 * DgsEntityNotFoundException::new); } return manufacturers.stream().filter(e ->
		 * e.getId() == Long.parseLong(id)).findFirst().get();
		 */
	}

}
