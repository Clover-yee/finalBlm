package com.example.api.service;


import com.example.api.entity.SmShopEntity;
import com.example.api.form.Shop;

import java.util.List;

public interface SmShopService {
    List<Shop> findAll();

    Shop findByShopId(int shopId);

    Shop findByShopTelAndShopPwd(String shopTel, String shopPwd);

    void updateShopInf(SmShopEntity shop);

    void updateShopPwd(int shopId, String shopPwd);
}
