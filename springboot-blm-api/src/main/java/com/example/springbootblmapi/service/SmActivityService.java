package com.example.springbootblmapi.service;

import com.example.springbootblmapi.form.Activity;

import java.util.List;

public interface SmActivityService {

    List<Activity>  findAllByShopId(int shopId);

    void updateActivityStatus();
}
