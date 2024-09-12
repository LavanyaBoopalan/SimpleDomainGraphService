package com.simple.dgs.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipmentInput {

	private String name;
	private float price;
	private boolean qualityPassed;
	private int manufacturerId;
	private int purchaseOrderId;
}