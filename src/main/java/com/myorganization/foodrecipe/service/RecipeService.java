package com.myorganization.foodrecipe.service;

import com.myorganization.foodrecipe.dto.RecipeDTO;
import com.myorganization.foodrecipe.entity.Recipe;

import java.util.List;

public interface RecipeService {
    public List<Recipe> getAllRecipe();
    public RecipeDTO getRecipeById(Integer id);
    public Recipe addRecipe(RecipeDTO recipeDTO);
    public RecipeDTO updateRecipe(Integer id, RecipeDTO recipeDTO);
    public String deleteRecipe(Integer id);
}
