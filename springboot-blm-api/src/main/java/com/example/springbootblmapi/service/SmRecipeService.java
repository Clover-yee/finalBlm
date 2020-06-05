package com.example.springbootblmapi.service;


import com.example.springbootblmapi.form.Recipe;

import java.util.List;

public interface SmRecipeService {
    List<Recipe> findAllByShopId(int shopId);

    void updateRecipe(int recipeId, String recipeName,
                      Double recipePrice, String recipeIntroduction,
                      Double recipeDiscount, int recipeRemain);

    List<Recipe> findTop5ByShopId(int shopId);


}
