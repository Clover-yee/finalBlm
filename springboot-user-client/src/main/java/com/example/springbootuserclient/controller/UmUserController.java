package com.example.springbootuserclient.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.springbootblmapi.service.UmUserService;
import com.example.springbootblmapi.util.AbstractJsonObject;
import com.example.springbootblmapi.util.Md5Util;
import com.example.springbootblmapi.util.StatusHouse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api("用户接口")
public class UmUserController {
    @Reference
    private UmUserService userService;

    // 登录是否要改成post？
    @GetMapping("/login")
    @ApiOperation("通过账号密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAccount", value = "用户登录账号"),
            @ApiImplicitParam(name = "userPwd", value = "密码")
    })
    public AbstractJsonObject login(@RequestParam(value = "userAccount") String userAccount,
                                    @RequestParam(value = "userPwd") String userPwd,
                                    @RequestParam(value = "token") String token){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userAccount",userAccount);
        jsonObject.put("userPwd",userPwd);
        if(Md5Util.getToken(jsonObject,token)){
            return userService.select(userAccount, userPwd);
        }else {
            AbstractJsonObject res=new AbstractJsonObject();
            res.setStatusObject(StatusHouse.COMMON_STATUS_TOKENERROR);
            return res;
        }

    }

}
