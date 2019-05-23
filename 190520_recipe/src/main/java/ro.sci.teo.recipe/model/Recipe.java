package ro.sci.teo.recipe.model;

import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getTotalCookingTime() {
        int sum = 0;
        for (Ingredient i : this.ingredients) {
            sum += i.getCookingTime();
        }
        return sum;
    }

    public int getCookingTemperature() {
        int maxTemp = 0;
        for (Ingredient i : this.ingredients) {
            if (maxTemp < i.getCookingTemp()) {
                maxTemp = i.getCookingTemp();
            }
        }
        return maxTemp;
    }
}
