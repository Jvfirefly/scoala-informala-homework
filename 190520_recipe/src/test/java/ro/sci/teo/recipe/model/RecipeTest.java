package ro.sci.teo.recipe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RecipeTest {

    @Test
    void getTotalCookingTimeOK() {
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
        //when
        int cookingTime = recipe1.getTotalCookingTime();
        //then
        Assertions.assertEquals(37, cookingTime);
    }

    @Test
    void getCookingTemperatureOK() {
        //given
        List<Ingredient> ingredients2 = new ArrayList<>();
        Ingredient ingredient21 =
                new Ingredient("water", Category.OTHER, 15, 120, 1);
        ingredients2.add(ingredient21);
        Ingredient ingredient22 =
                new Ingredient("flour", Category.DAIRY, 15, 110, 99);
        ingredients2.add(ingredient22);
        Recipe recipe2 = new Recipe("bread", ingredients2);
        //when
        int maxCookingTemp = recipe2.getCookingTemperature();
        //then
        Assertions.assertEquals(120, maxCookingTemp);
    }
}