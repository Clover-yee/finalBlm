package com.example.springbootblmapi.service;

import com.example.springbootblmapi.entity.SmShopEntity;
import com.example.springbootblmapi.form.Shop;
import com.example.springbootblmapi.form.ShopForm;
import com.example.springbootblmapi.util.AbstractJsonObject;

import java.util.List;

public interface SmShopService {
    List<Shop> findAll();

    Shop findByShopId(int shopId);

    AbstractJsonObject findByShopTelAndShopPwd(String shopTel, String shopPwd);

    void updateShopInf(ShopForm form);

    void updateShopPwd(int shopId, String shopPwd);
}
