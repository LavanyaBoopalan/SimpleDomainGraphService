package com.simple.dgs.context;

import java.util.List;

import com.simple.dgs.model.Equipment;
import com.simple.dgs.model.Manufacturer;
import com.simple.dgs.model.PurchaseOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomContext {
    private final List<Equipment> equipments;
    private final List<Manufacturer> manufacturers;
    private final List<PurchaseOrder> purchaseOrders;
}
