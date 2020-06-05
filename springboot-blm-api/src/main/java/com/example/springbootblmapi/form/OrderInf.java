package com.example.springbootblmapi.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInf {
    private String recipeName;
    private Integer orderRecipeNumber;
}
