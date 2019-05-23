package ro.sci.teo.recipe.model;

public class Ingredient {
    private String name;
    private Category category;
    private int cookingTime;
    private int cookingTemp;
    private int calories;

    public Ingredient() {
    }

    public Ingredient(String name, Category category, int cookingTime, int cookingTemp, int calories) {
        this.name = name;
        this.category = category;
        this.cookingTime = cookingTime;
        this.cookingTemp = cookingTemp;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public int getCookingTemp() {
        return cookingTemp;
    }

    public void setCookingTemp(int cookingTemp) {
        this.cookingTemp = cookingTemp;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
