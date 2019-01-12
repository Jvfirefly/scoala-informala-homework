package ro.sci.teo.ian9.celsius;

import java.util.Scanner;

/**
 * 2. Fahrenheit to Celsius Conversion
 * - create a method that converts temperature from Fahrenheit to Celsius.
 * - write a program that for a given (by the user) body temperature, measured in Fahrenheit degrees,
 * outputs it in Celsius degrees, with the following message: "Your body temperature in Celsius degrees is X",
 * where X is respectively the Celsius degrees. In addition if the measured temperature in Celsius is higher
 * than 37 degrees, the program should warn the user that they are ill, with the following message
 * "You are ill!". ( use the method created before)
 */

public class FahrenheitToCelsius {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input your body temperature here: ");
        float fahrenheit = sc.nextFloat();

        float celsius = convertToCelsius(fahrenheit);
        System.out.println("Your body temperature in Celsius degrees is " + celsius);
        if (celsius > 37)
            System.out.println("You are ill!");

    }

    /**
     * This method makes the Fahrenheit to Celsius conversion.
     */
    private static float convertToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
