package ro.sci.teo.recipe.service;

import ro.sci.teo.recipe.model.Ingredient;
import ro.sci.teo.recipe.model.Recipe;

public class CookingThread implements Runnable {
    private Recipe recipe;

    public CookingThread(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void run() {
        try {
            for (Ingredient i : recipe.getIngredients()) {
                Thread.sleep(i.getCookingTime() * 1000);
                System.out.println("Cooking " + recipe.getName() + " - " + i.getName() + " is ready!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The " + recipe.getName() + " is done!");
    }
}
