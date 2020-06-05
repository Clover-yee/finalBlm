package com.example.springbootblmapi.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int userId;
    String userName;
    String userTel;
    String userAddress;
    byte[] userImage;
}
