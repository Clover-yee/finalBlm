package com.example.api.form;

import cn.zucc.edu.blmr.entity.OmOrderInfEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderForm {
    Integer shopId;
    Integer userId;
    String orderRemark;
    Double orderMoney;
    Double orderReduce;
    List<OmOrderInfEntity> orderInfList;
    String userTele;
}
