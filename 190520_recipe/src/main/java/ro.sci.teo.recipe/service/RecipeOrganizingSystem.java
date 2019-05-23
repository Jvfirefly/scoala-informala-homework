package ro.sci.teo.recipe.service;

import ro.sci.teo.recipe.model.Category;
import ro.sci.teo.recipe.model.Ingredient;
import ro.sci.teo.recipe.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeOrganizingSystem {
    /**
     * Selects all the recipes that have at least one ingredient in a specific category.
     * @param allRecipes recipes list
     * @param category chosen category
     * @return list of valid recipes
     */
    public List<Recipe> getRecipesWithIngredientCat(List<Recipe> allRecipes, Category category) {
        List<Recipe> selectedRecipes = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            for (Ingredient i : recipe.getIngredients())
                if (i.getCategory().equals(category)) {
                    selectedRecipes.add(recipe);
                    break;
                }
        }
        return selectedRecipes;
    }

    /**
     * Selects all the recipes that don't have ingredients in a specific category.
     * @param allRecipes recipes list
     * @param category chosen category
     * @return list of valid recipes
     */
    public List<Recipe> getRecipesWithIngredientNoCat(List<Recipe> allRecipes, Category category) {
        List<Recipe> selectedRecipes = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            boolean isNotInCategory = true;
            for (Ingredient i : recipe.getIngredients())
                if (i.getCategory().equals(category)) {
                    isNotInCategory = false;
                    break;
                }
            if(isNotInCategory){
                selectedRecipes.add(recipe);
            }
        }
        return selectedRecipes;
    }

    public void cook(Recipe recipe) {
        Thread t = new Thread(new CookingThread(recipe));
        t.start();
    }
}
