package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInfAllApp {
    String shopName;
    List<OrderInfApp> orderInfApps;
    Double orderMoney;

    public List<OrderInfApp> getOrderInfApps() {
        return orderInfApps;
    }

    public void setOrderInfApps(List<OrderInfApp> orderInfApps) {
        this.orderInfApps = orderInfApps;
    }
}
