package com.myorganization.foodrecipe.service;

import com.myorganization.foodrecipe.dto.RecipeDTO;
import com.myorganization.foodrecipe.entity.Recipe;
import com.myorganization.foodrecipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public RecipeDTO getRecipeById(Integer id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if(recipe == null) {
            return null;
        } else {
            RecipeDTO recipeDTO = RecipeDTO.builder()
                    .title(recipe.title)
                    .description(recipe.description)
                    .ingredients(recipe.ingredients)
                    .instructions(recipe.instructions)
                    .imgurl(recipe.imgurl)
                    .build();
            return recipeDTO;
        }
    }

    @Override
    public Recipe addRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = Recipe.builder()
                .title(recipeDTO.getTitle())
                .description(recipeDTO.getDescription())
                .ingredients(recipeDTO.getIngredients())
                .instructions(recipeDTO.getInstructions())
                .imgurl(recipeDTO.getImgurl())
                .build();

        return recipeRepository.save(recipe);
    }

    @Override
    public RecipeDTO updateRecipe(Integer id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if(recipe == null) {
            return null;
        } else {
            Recipe updatedRecipe = Recipe.builder()
                    .id(id)
                    .title(recipeDTO.title)
                    .description(recipeDTO.description)
                    .ingredients(recipeDTO.ingredients)
                    .instructions(recipeDTO.instructions)
                    .imgurl(recipeDTO.imgurl)
                    .build();

            recipeRepository.save(updatedRecipe);
            return recipeDTO;
        }
    }

    @Override
    public String deleteRecipe(Integer id) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        if(recipe == null) {
            return "Id: " + id + " not found! Deletion unsuccessful.";
        } else {
            recipeRepository.delete(recipe);
            return "Recipe id: " + id + " is deleted successfully!";
        }
    }
}
