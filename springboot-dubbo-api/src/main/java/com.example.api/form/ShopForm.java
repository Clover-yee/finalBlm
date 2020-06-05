package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopForm {
    int shopId;
    String shopName;
    String shopAddress;
    String shopTel;
    String shopNotice;
}
