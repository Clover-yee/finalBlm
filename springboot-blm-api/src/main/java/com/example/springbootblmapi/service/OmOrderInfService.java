package com.example.springbootblmapi.service;

import com.example.springbootblmapi.entity.OmOrderInfEntity;
import com.example.springbootblmapi.form.OrderInf;
import com.example.springbootblmapi.form.OrderInfApp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OmOrderInfService {
    List<OrderInf>  getOrderInfName(int orderId);

    void insertSelective(OmOrderInfEntity form);

    List<OrderInfApp> getOrderInfAll(int orderId);

    Integer insert(OmOrderInfEntity omOrderInfEntity);
}
