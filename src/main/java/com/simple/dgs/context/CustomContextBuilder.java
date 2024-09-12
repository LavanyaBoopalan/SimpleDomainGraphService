package com.simple.dgs.context;

import java.util.List;

import org.springframework.stereotype.Component;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import com.simple.dgs.model.Equipment;
import com.simple.dgs.model.Manufacturer;
import com.simple.dgs.model.PurchaseOrder;

@Component
public class CustomContextBuilder implements DgsCustomContextBuilder<CustomContext> {
	private List<Equipment> equipments;
    private List<Manufacturer> manufacturers;
    private List<PurchaseOrder> purchaseOrders;
    
    public CustomContextBuilder customContext(List<Equipment> equipments, List<Manufacturer> manufacturers, List<PurchaseOrder> purchaseOrders) {
        this.equipments = equipments;
        this.manufacturers = manufacturers;
        this.purchaseOrders = purchaseOrders;
        return this;
    }

    @Override
    public CustomContext build() {
        return new CustomContext(equipments, manufacturers, purchaseOrders);
    }
}
