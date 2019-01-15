package ro.sci.teo.ian9.max;

import java.util.Scanner;

/**
 * 1. Calculate Max
 * - Create a method getMax() with two integer (int) parameters, that returns maximal of the two numbers.
 * - Write a program that reads three numbers from the console and prints the biggest of them. Use the getMax()
 * method you just created.
 */

public class BiggestNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the first number: ");
        int x = sc.nextInt();
        System.out.print("Input the second number: ");
        int y = sc.nextInt();
        System.out.print("Input the last number: ");
        int z = sc.nextInt();

        System.out.println("\nThe biggest number is: " + getMax(z, getMax(x, y)));
    }

    /**
     * This method finds the maximum of two numbers.
     *
     * @param a the first of the two numbers to be compared
     * @param b the second of the two numbers to be compared
     * @return the maximum value
     */
    private static int getMax(int a, int b) {
        if (a > b)
            return a;
        return b;
    }
}
