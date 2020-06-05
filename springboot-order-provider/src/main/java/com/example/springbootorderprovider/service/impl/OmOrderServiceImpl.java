package com.example.springbootorderprovider.service.impl;

import com.example.springbootblmapi.entity.OmOrderEntity;
import com.example.springbootblmapi.form.Order;
import com.example.springbootblmapi.form.OrderForm;
import com.example.springbootblmapi.form.OrderInfAllApp;
import com.example.springbootblmapi.form.ShopOrder;
import com.example.springbootblmapi.service.OmOrderService;
import com.example.springbootorderprovider.mapper.OmOrderMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Service
@Component
public class OmOrderServiceImpl implements OmOrderService {
    @Autowired
    private OmOrderMapper mapper;

    @Override
    public List<Order> getOrderList(int userId) {
        return mapper.getOrderList(userId);
    }

    @Override
    public List<ShopOrder> getOrderListByShopId(int shopId) {
        return mapper.getOrderListByShopId(shopId);
    }

    @Override
    public Integer insert(OrderForm form) {
        OmOrderEntity omOrderEntity = new OmOrderEntity();
        BeanUtils.copyProperties(form, omOrderEntity);
        omOrderEntity.setOrderStatus("下单");
        omOrderEntity.setOrderCreatetime(new Timestamp(System.currentTimeMillis()));
        return mapper.insert(omOrderEntity);
    }

    @Override
    public OrderInfAllApp getOrderByOrderId(int orderId) {
        return mapper.getOrderByOrderIdApp(orderId);
    }
}
