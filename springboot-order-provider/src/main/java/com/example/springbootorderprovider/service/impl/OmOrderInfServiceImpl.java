package com.example.springbootorderprovider.service.impl;


import com.example.springbootblmapi.entity.OmOrderInfEntity;
import com.example.springbootblmapi.form.OrderInf;
import com.example.springbootblmapi.form.OrderInfApp;
import com.example.springbootblmapi.service.OmOrderInfService;
import com.example.springbootorderprovider.mapper.OmOrderInfMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class OmOrderInfServiceImpl implements OmOrderInfService {
    @Autowired
    private OmOrderInfMapper mapper;

    @Override
    public List<OrderInf> getOrderInfName(int orderId) {
        return mapper.getOrderInfName(orderId);
    }

    @Override
    public void insertSelective(OmOrderInfEntity form) {
        mapper.insertSelective(form);
    }

    @Override
    public List<OrderInfApp> getOrderInfAll(int orderId) {
        return mapper.getOrderInfByOrderIdApp(orderId);
    }

    @Override
    public Integer insert(OmOrderInfEntity omOrderInfEntity) {
        return mapper.insert(omOrderInfEntity);
    }
}
