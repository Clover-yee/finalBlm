package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shop {
    int shopId;
    String shopName;
    String shopAddress;
    String shopTel;
    Double shopRating;
    String shopNotice;
    byte[] shopTrademark;
    String shopStatus;
}
