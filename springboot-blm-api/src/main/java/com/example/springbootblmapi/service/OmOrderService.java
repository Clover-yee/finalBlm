package com.example.springbootblmapi.service;

import com.example.springbootblmapi.form.Order;
import com.example.springbootblmapi.form.OrderForm;
import com.example.springbootblmapi.form.OrderInfAllApp;
import com.example.springbootblmapi.form.ShopOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmOrderService {

    List<Order> getOrderList(int userId);

    List<ShopOrder> getOrderListByShopId(int shopId);

    Integer insert(OrderForm form);

    OrderInfAllApp getOrderByOrderId(int orderId);

}
