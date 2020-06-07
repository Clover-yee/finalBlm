package com.example.springbootorderprovider.service.impl;

import com.example.springbootblmapi.entity.OmOrderEntity;
import com.example.springbootblmapi.entity.OmOrderInfEntity;
import com.example.springbootblmapi.form.*;
import com.example.springbootblmapi.service.OmOrderServiceTransactional;
import com.example.springbootblmapi.service.SmRecipeService;
import com.example.springbootblmapi.service.SmShopService;
import com.example.springbootorderprovider.mapper.OmOrderInfMapper;
import com.example.springbootorderprovider.mapper.OmOrderMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service(version = "2.0.0")
@Component
public class OmOrderServiceImpl2 implements OmOrderServiceTransactional {
    private Integer orderId;

    @Autowired
    private OmOrderMapper mapper;

    @Autowired
    private OmOrderInfMapper omOrderInfMapper;

    @Reference(version = "2.0.0")
    private SmRecipeService smRecipeService;

    @Override
    public List<Order> getOrderList(int userId) {
        return null;
    }

    @Override
    public List<ShopOrder> getOrderListByShopId(int shopId) {
        return null;
    }

    @Override
    @Compensable(confirmMethod = "confirmInsert", cancelMethod = "cancelInsert", asyncConfirm = true)
    @Transactional
    public Integer insert(OrderForm form) {
        OmOrderEntity omOrderEntity = new OmOrderEntity();
        BeanUtils.copyProperties(form, omOrderEntity);
        omOrderEntity.setOrderStatus("下单");
        omOrderEntity.setOrderCreatetime(new Timestamp(System.currentTimeMillis()));
        orderId=mapper.insert(omOrderEntity);
        for (OmOrderInfEntity omOrderInfEntity : form.getOrderInfList()) {
            smRecipeService.updateRecipeRemain(omOrderInfEntity.getRecipeId(),omOrderInfEntity.getOrderRecipeNumber());
        }
        for (OmOrderInfEntity omOrderInfEntity : form.getOrderInfList()) {
            omOrderInfEntity.setOrderId(orderId);
            omOrderInfMapper.insert(omOrderInfEntity);
        }
        return orderId;
    }

    @Override
    @Transactional
    public Integer confirmInsert(OrderForm form){
        return orderId;
    }

    @Override
    @Transactional
    public Integer cancelInsert(OrderForm form){
        if(orderId!=null){
            OmOrderEntity omOrderEntity = new OmOrderEntity();
            omOrderEntity.setOrderId(orderId);
            mapper.deleteByExample(omOrderEntity);

            OmOrderInfEntity omOrderInfEntity = new OmOrderInfEntity();
            omOrderInfEntity.setOrderId(orderId);
            omOrderInfMapper.deleteByExample(omOrderInfEntity);
        }
        return 0;
    }


    @Override
    public OrderInfAllApp getOrderByOrderId(int orderId) {
        return null;
    }
}
