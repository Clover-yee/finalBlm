package com.example.springbootblmapi.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipe {
    private Integer recipeId;
    private String recipeName;
    private Double recipePrice;
    private Integer monthlySale;
    private String recipeIntroduction;
    private Integer recipeRemain;
    private Double recipeDiscount;

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    private byte[] recipeImage;
}
