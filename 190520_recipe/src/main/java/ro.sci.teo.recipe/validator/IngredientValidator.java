package ro.sci.teo.recipe.validator;

import ro.sci.teo.recipe.model.Ingredient;

public class IngredientValidator {
    public void validate(Ingredient ingredient) {
        if (ingredient.getCookingTime() < 0) {
            System.out.println("The ingredient" + ingredient.getName() + "has a negative cooking time!");
        }
    }
}
