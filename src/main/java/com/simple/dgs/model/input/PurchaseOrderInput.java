package com.simple.dgs.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseOrderInput{
	
	private String companyName;
	private String orderDate;
	private float price;
	private int shipmentId;
	
}