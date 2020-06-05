package com.example.springbootuserprovider.service.impl;

import com.example.springbootblmapi.entity.UmUserEntity;
import com.example.springbootblmapi.service.UmUserService;
import com.example.springbootuserprovider.mapper.UmUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class UmUserServiceImpl implements UmUserService {
    @Autowired
    private UmUserMapper userMapper;

    @Override
    public List<UmUserEntity> select(UmUserEntity entity) {
        return userMapper.select(entity);
    }

}
