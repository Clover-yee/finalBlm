package com.example.springbootblmapi.service;

import com.example.springbootblmapi.entity.UmUserEntity;
import com.example.springbootblmapi.util.AbstractJsonObject;


import java.util.List;

public interface UmUserService {

    AbstractJsonObject select(String userAccount, String userPwd);
}
