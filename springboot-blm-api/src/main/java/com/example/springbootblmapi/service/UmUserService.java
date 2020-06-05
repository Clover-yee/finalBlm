package com.example.springbootblmapi.service;

import com.example.springbootblmapi.entity.UmUserEntity;


import java.util.List;

public interface UmUserService {

    List<UmUserEntity>  select(UmUserEntity entity);
}
