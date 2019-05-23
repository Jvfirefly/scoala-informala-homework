package ro.sci.teo.recipe.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.sci.teo.recipe.model.Category;
import ro.sci.teo.recipe.model.Ingredient;
import ro.sci.teo.recipe.model.Recipe;

import java.util.ArrayList;
import java.util.List;

class RecipeOrganizingSystemTest {

    @Test
    void getRecipesWithIngredientCatOK() {
        //given
        List<Ingredient> ingredients1 = new ArrayList<>();
        Ingredient ingredient11 =
                new Ingredient("ham", Category.MEAT, 12, 100, 200);
        ingredients1.add(ingredient11);
        Ingredient ingredient12 =
                new Ingredient("onion", Category.VEGETABLE, 10, 120, 50);
        ingredients1.add(ingredient12);
        Ingredient ingredient13 =
                new Ingredient("flour", Category.DAIRY, 15, 120, 70);
        ingredients1.add(ingredient13);
        Recipe recipe1 = new Recipe("pizza", ingredients1);

        List<Ingredient> ingredients2 = new ArrayList<>();
        Ingredient ingredient21 =
                new Ingredient("water", Category.OTHER, 15, 120, 1);
        ingredients2.add(ingredient21);
        Ingredient ingredient22 =
                new Ingredient("flour", Category.DAIRY, 15, 110, 99);
        ingredients2.add(ingredient22);
        Recipe recipe2 = new Recipe("bread", ingredients2);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        //when
        RecipeOrganizingSystem recipeOrganizingSystem = new RecipeOrganizingSystem();
        List<Recipe> selectedRecipes = recipeOrganizingSystem.getRecipesWithIngredientCat(recipes, Category.DAIRY);
        //then
        Assertions.assertEquals(recipes, selectedRecipes);
    }

    @Test
    void getRecipesWithIngredientNoCatNotOK() {
        //given
        List<Ingredient> ingredients1 = new ArrayList<>();
        Ingredient ingredient11 =
                new Ingredient("ham", Category.MEAT, 12, 100, 200);
        ingredients1.add(ingredient11);
        Ingredient ingredient12 =
                new Ingredient("onion", Category.VEGETABLE, 10, 120, 50);
        ingredients1.add(ingredient12);
        Ingredient ingredient13 =
                new Ingredient("flour", Category.DAIRY, 15, 120, 70);
        ingredients1.add(ingredient13);
        Recipe recipe1 = new Recipe("pizza", ingredients1);

        List<Ingredient> ingredients2 = new ArrayList<>();
        Ingredient ingredient21 =
                new Ingredient("water", Category.OTHER, 15, 120, 1);
        ingredients2.add(ingredient21);
        Ingredient ingredient22 =
                new Ingredient("flour", Category.DAIRY, 15, 110, 99);
        ingredients2.add(ingredient22);
        Recipe recipe2 = new Recipe("bread", ingredients2);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        //when
        RecipeOrganizingSystem recipeOrganizingSystem = new RecipeOrganizingSystem();
        List<Recipe> selectedRecipes = recipeOrganizingSystem.getRecipesWithIngredientNoCat(recipes, Category.VEGETABLE);
        //then
        Assertions.assertNotEquals(recipes, selectedRecipes);
    }
}