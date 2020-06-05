package com.example.springbootblmapi.service;


import com.example.springbootblmapi.form.ShopEva;

import java.util.List;

public interface SmShopEvaService {
    List<ShopEva> findAllByShopId(int shopId);
}
