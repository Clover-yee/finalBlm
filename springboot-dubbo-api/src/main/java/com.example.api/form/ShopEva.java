package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShopEva {
    int userId;
    String userName;
    byte[] userImage;
    int shopEvaId;
    String content;
    byte[] shopEvaImage;
    double shopEvaRating;
}
