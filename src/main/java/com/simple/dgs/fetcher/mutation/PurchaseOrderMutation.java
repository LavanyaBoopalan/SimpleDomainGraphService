package com.simple.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.simple.dgs.model.PurchaseOrder;
import com.simple.dgs.model.input.PurchaseOrderInput;
import com.simple.dgs.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class PurchaseOrderMutation {
	 
	 private final PurchaseOrderRepository purchaseOrderRepository;

		@DgsData(parentType = "MutationResolver", field = "createPurchaseOrder")
		public PurchaseOrder createPurchaseOrder(@InputArgument("purchaseOrder") PurchaseOrderInput purchaseOrder) {
			return purchaseOrderRepository.save(PurchaseOrder.builder().companyName(purchaseOrder.getCompanyName()).orderDate(purchaseOrder.getOrderDate())
					.price(purchaseOrder.getPrice()).shipmentId(purchaseOrder.getShipmentId()).build());
		}

}
