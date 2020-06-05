package com.example.springbootuserprovider.service.impl;

import com.example.springbootblmapi.entity.UmUserEntity;
import com.example.springbootblmapi.form.User;
import com.example.springbootblmapi.service.UmUserService;
import com.example.springbootblmapi.util.AbstractJsonObject;
import com.example.springbootblmapi.util.SingleObject;
import com.example.springbootblmapi.util.StatusHouse;
import com.example.springbootuserprovider.mapper.UmUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class UmUserServiceImpl implements UmUserService {
    @Autowired
    private UmUserMapper userMapper;

    @Override
    public AbstractJsonObject select(String userAccount, String userPwd) {
        UmUserEntity entity = new UmUserEntity();
        entity.setUserAccount(userAccount);
        entity.setUserPwd(userPwd);
        List<UmUserEntity> entities = userMapper.select(entity);
        if(entities.size() == 0)
        {
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_NORECORD);
            return res;
        }
        else if (entities.size() == 1) {
            User user = new User();
            BeanUtils.copyProperties(entities.get(0), user);
            SingleObject res=new SingleObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_OK);
            res.setData(user);
            return res;
        }
        else{
            System.out.println("exist same username");
            return null;
        }
    }

}
