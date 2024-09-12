package com.simple.dgs.fetcher.query;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.simple.dgs.context.CustomContext;
import com.simple.dgs.context.CustomContextBuilder;
import com.simple.dgs.model.Equipment;
import com.simple.dgs.repository.EquipmentRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class EquipmentDataFetcher {
	
	private final EquipmentRepository equipmentRepository;
//	private final CustomContextBuilder contextBuilder;
	
	
	 @DgsData(parentType = "QueryResolver", field = "equipments")
	    public Iterable<Equipment> findAll(DgsDataFetchingEnvironment dfe) {
	        var equipments = (List<Equipment>) equipmentRepository.findAll();
//	        contextBuilder.customContext(equipments, null, null).build();
	        return equipments;
	    }
	 
	 @DgsData(parentType = "QueryResolver", field = "equipment")
		public Equipment findById(@InputArgument("id") String id, DgsDataFetchingEnvironment dfe) {
		 return equipmentRepository.findById(Long.parseLong(id)).orElseThrow(DgsEntityNotFoundException::new);
			/*
			 * CustomContext customContext = DgsContext.getCustomContext(dfe); var
			 * equipments = customContext.getEquipments(); if
			 * (CollectionUtils.isEmpty(equipments)) { return
			 * equipmentRepository.findById(Long.parseLong(id)).orElseThrow(
			 * DgsEntityNotFoundException::new); } return
			  equipments.stream().filter(e -> e.getId() == Long.parseLong(id)).findFirst().get();*/
		}

}