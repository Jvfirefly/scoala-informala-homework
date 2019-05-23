package ro.sci.teo.recipe;

import ro.sci.teo.recipe.model.Category;
import ro.sci.teo.recipe.model.Ingredient;
import ro.sci.teo.recipe.model.Recipe;
import ro.sci.teo.recipe.service.RecipeOrganizingSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1st recipe
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
        //2nd recipe
        List<Ingredient> ingredients2 = new ArrayList<>();
        Ingredient ingredient21 =
                new Ingredient("water", Category.OTHER, 15, 120, 1);
        ingredients2.add(ingredient21);
        Ingredient ingredient22 =
                new Ingredient("flour", Category.DAIRY, 15, 110, 99);
        ingredients2.add(ingredient22);
        Recipe recipe2 = new Recipe("bread", ingredients2);
        //3rd recipe
        List<Ingredient> ingredients3 = new ArrayList<>();
        Ingredient ingredient31 =
                new Ingredient("china cabbage", Category.VEGETABLE, 5, 0, 30);
        ingredients3.add(ingredient31);
        Recipe recipe3 = new Recipe("salad", ingredients3);

        //cook recipes
        RecipeOrganizingSystem recipeOrganizingSystem = new RecipeOrganizingSystem();
        recipeOrganizingSystem.cook(recipe1);
        recipeOrganizingSystem.cook(recipe2);
        recipeOrganizingSystem.cook(recipe3);
    }
}
