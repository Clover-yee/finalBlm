package com.example.springbootshopprovider.service.impl;


import com.example.springbootblmapi.form.ShopEva;
import com.example.springbootblmapi.service.SmShopEvaService;
import com.example.springbootshopprovider.mapper.SmShopEvaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmShopEvaServiceImpl implements SmShopEvaService {
    @Autowired
    private SmShopEvaMapper mapper;

    @Override
    public List<ShopEva> findAllByShopId(int shopId) {
        return mapper.getShopEva(shopId);
    }
}
