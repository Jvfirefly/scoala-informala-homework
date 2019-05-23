package ro.sci.teo.recipe.validator;

import ro.sci.teo.recipe.model.Recipe;

public class RecipeValidator {
    public void validate(Recipe recipe) {
        if (recipe.getIngredients().isEmpty()) {
            System.out.println("The recipe " + recipe.getName() + " does NOT contain any ingredients!");
        }
    }
}
