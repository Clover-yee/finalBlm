package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInfApp {
    String recipeName;
    Integer orderRecipeNumber;
    Double money;
}
