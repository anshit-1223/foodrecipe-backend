package com.myorganization.foodrecipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    public String title;
    public String description;
    public String ingredients;
    public String instructions;
    public String imgurl;
}
