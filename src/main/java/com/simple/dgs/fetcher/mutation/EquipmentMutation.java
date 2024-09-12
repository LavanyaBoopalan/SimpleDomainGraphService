package com.simple.dgs.fetcher.mutation;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.simple.dgs.model.Equipment;
import com.simple.dgs.model.Manufacturer;
import com.simple.dgs.model.PurchaseOrder;
import com.simple.dgs.model.input.EquipmentInput;
import com.simple.dgs.repository.EquipmentRepository;
import com.simple.dgs.repository.ManufacturerRepository;
import com.simple.dgs.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class EquipmentMutation {

	private final EquipmentRepository equipmentRepository;
	private final ManufacturerRepository manufacturerRepository;
	private final PurchaseOrderRepository purchaseOrderRepository;

	@DgsData(parentType = "MutationResolver", field = "createEquipment")
	public Equipment createEquipment(@InputArgument("equipment") EquipmentInput equipment) {
		Manufacturer manufacturer = manufacturerRepository.findById((long) equipment.getManufacturerId())
                .orElseThrow(DgsEntityNotFoundException::new);
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById((long) equipment.getPurchaseOrderId())
				.orElseThrow(DgsEntityNotFoundException::new);
		return equipmentRepository.save(Equipment.builder().name(equipment.getName()).price(equipment.getPrice())
				.qualityPassed(equipment.isQualityPassed()).manufacturer(manufacturer).purchaseOrder(purchaseOrder)
				.build());
	}
}

