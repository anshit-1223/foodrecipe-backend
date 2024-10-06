package com.myorganization.foodrecipe.controller;

import com.myorganization.foodrecipe.dto.RecipeDTO;
import com.myorganization.foodrecipe.entity.Recipe;
import com.myorganization.foodrecipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipeService.getAllRecipe(), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Integer id) {
        return new ResponseEntity<>(recipeService.getRecipeById(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeDTO recipeDTO) {
        return new ResponseEntity<>(recipeService.addRecipe(recipeDTO), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Integer id, @RequestBody RecipeDTO recipeDTO) {
        return new ResponseEntity<>(recipeService.updateRecipe(id, recipeDTO), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable Integer id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id), HttpStatusCode.valueOf(200));
    }

}
