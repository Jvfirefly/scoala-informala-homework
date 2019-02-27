package ro.sci.teo.feb11.celsius;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
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
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Input your body temperature here: ");
            double fahrenheit = sc.nextDouble();

            double celsius = new FahrenheitToCelsius().convertToCelsius(fahrenheit);
            System.out.println("Your body temperature in Celsius degrees is " + celsius);
            if (celsius > 37)
                System.out.println("You are ill!");
        } catch (InputMismatchException e) {
            System.out.println("The program argument should be a number.");
        }
    }

    /**
     * This method makes the Fahrenheit to Celsius conversion.
     */
    public double convertToCelsius(double fahrenheit) {
        return round((fahrenheit - 32) * 5 / 9);
    }

    /**
     * This method rounds a double value to two decimals.
     *
     * @param value the double value that needs to be rounded
     * @return the rounded double value
     */
    public double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
