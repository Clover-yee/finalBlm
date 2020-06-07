package com.example.springbootshopprovider.service.impl;


import com.example.springbootblmapi.entity.SmRecipeEntity;
import com.example.springbootblmapi.form.Recipe;
import com.example.springbootblmapi.service.SmRecipeService;
import com.example.springbootshopprovider.mapper.SmRecipeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmRecipeServiceImpl implements SmRecipeService {
    @Autowired
    private SmRecipeMapper mapper;

    @Override
    public List<Recipe> findAllByShopId(int shopId) {
        Example example = new Example(SmRecipeEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", shopId);
        List<SmRecipeEntity> entities = mapper.selectByExample(example);
        List<Recipe> recipes = new ArrayList<>();
        for (SmRecipeEntity entity : entities) {
            Recipe recipe = new Recipe();
            BeanUtils.copyProperties(entity, recipe);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public void updateRecipe( int recipeId, String recipeName,
                             Double recipePrice, String recipeIntroduction,
                             Double recipeDiscount,  int recipeRemain) {
        Example example = new Example(SmRecipeEntity.class);
        Example.Criteria criteria = example.createCriteria();
        SmRecipeEntity entity = new SmRecipeEntity();
        entity.setRecipeName(recipeName);
        entity.setRecipeIntroduction(recipeIntroduction);
        entity.setRecipePrice(recipePrice);
        entity.setRecipeDiscount(recipeDiscount);
        entity.setRecipeRemain(recipeRemain);
        criteria.andEqualTo("recipeId", recipeId);
        mapper.updateByExampleSelective(entity, example);
    }

    @Override
    public List<Recipe> findTop5ByShopId(int shopId) {
        List<Recipe> recipes = new ArrayList<>();
        recipes = mapper.getMax5Recipe(shopId);
        return recipes;
    }
}
