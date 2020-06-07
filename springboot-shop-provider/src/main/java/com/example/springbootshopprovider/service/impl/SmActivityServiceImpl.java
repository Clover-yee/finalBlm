package com.example.springbootshopprovider.service.impl;


import com.example.springbootblmapi.entity.SmActivityEntity;
import com.example.springbootblmapi.form.Activity;
import com.example.springbootblmapi.service.SmActivityService;
import com.example.springbootshopprovider.mapper.SmActivityMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmActivityServiceImpl implements SmActivityService {
    @Autowired
    private SmActivityMapper mapper;

    @Override
    public List<Activity> findAllByShopId(int shopId) {
        SmActivityEntity selectEntity = new SmActivityEntity();
        selectEntity.setShopId(shopId);
        List<SmActivityEntity> entities = mapper.select(selectEntity);
        List<Activity> res = new ArrayList<>();
        for (SmActivityEntity entity: entities) {
            Activity activity = new Activity();
            BeanUtils.copyProperties(entity, activity);
            res.add(activity);
        }
        return res;
    }

    @Override
    public void updateActivityStatus() {
    }
}
