package com.example.springbootuserprovider.service.impl;

import com.example.springbootblmapi.entity.UmUserEntity;
import com.example.springbootblmapi.service.UmUserService;
import com.example.springbootuserprovider.mapper.UmUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmUserServiceImpl implements UmUserService {
    @Autowired
    private  UmUserMapper userMapper;

    @Override
    public List<UmUserEntity> select(UmUserEntity entity) {
        return userMapper.select(entity);
    }
}
