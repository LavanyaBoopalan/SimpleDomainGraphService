package com.simple.dgs.fetcher.query;

import java.util.List;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.simple.dgs.context.CustomContextBuilder;
import com.simple.dgs.model.PurchaseOrder;
import com.simple.dgs.repository.EquipmentRepository;
import com.simple.dgs.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class PurchaseOrderDatafetcher {
	
	private final PurchaseOrderRepository purchaseOrderRepository;
	private final EquipmentRepository equipmentRepository;
	private final CustomContextBuilder contextBuilder;
	
	
	 @DgsData(parentType = "QueryResolver", field = "purchaseOrders")
	    public Iterable<PurchaseOrder> findAll(DgsDataFetchingEnvironment dfe) {
	        var purchaseOrders = (List<PurchaseOrder>) purchaseOrderRepository.findAll();
//	        contextBuilder.customContext(null, null, purchaseOrders).build();
	        return purchaseOrders;
	    }
	 
	 @DgsData(parentType = "QueryResolver", field = "purchaseOrder")
		public PurchaseOrder findById(@InputArgument("id") String id, DgsDataFetchingEnvironment dfe) {
		    return purchaseOrderRepository.findById(Long.parseLong(id)).orElseThrow(DgsEntityNotFoundException::new);
			/*
			 * CustomContext customContext = DgsContext.getCustomContext(dfe); var
			 * purchaseOrders = customContext.getPurchaseOrders(); if
			 * (CollectionUtils.isEmpty(purchaseOrders)) { return
			 * purchaseOrderRepository.findById(Long.parseLong(id)).orElseThrow(
			 * DgsEntityNotFoundException::new); } return purchaseOrders.stream().filter(e
			 * -> e.getId() == Long.parseLong(id)).findFirst().get();
			 */
		}

}
