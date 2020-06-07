package com.example.springbootblmapi.service;

import com.example.springbootblmapi.form.Order;
import com.example.springbootblmapi.form.OrderForm;
import com.example.springbootblmapi.form.OrderInfAllApp;
import com.example.springbootblmapi.form.ShopOrder;

import java.util.List;

public interface OmOrderServiceTransactional {

    List<Order> getOrderList(int userId);

    List<ShopOrder> getOrderListByShopId(int shopId);

    Integer insert(OrderForm form);

    Integer confirmInsert(OrderForm form);

    Integer cancelInsert(OrderForm form);

    OrderInfAllApp getOrderByOrderId(int orderId);


}
