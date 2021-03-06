package ro.sci.teo.ian9.time;

import java.util.Scanner;

/**
 * 3. Input Data Validation
 * - write a program that asks the user what time it is, by printing on the console "What time is it?".
 * Then the user must enter two numbers – one for hours and one for minutes.
 * If the input data represents a valid time, the program must output the message " The time is hh:mm now.",
 * where hh respectively means the hours, and mm – the minutes. If the entered hours or minutes are not valid,
 * the program must print the message " Incorrect time!". The validation must be implemented in a separate method.
 */

public class TimeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What time is it?");
        System.out.print("Enter the hour: ");
        int h = sc.nextInt();
        System.out.print("Enter the minute: ");
        int minute = sc.nextInt();

        validateTime(h, minute);
    }

    private static void validateTime(int hour, int min) {
        if (hour < 0 || hour > 23 || min < 0 || min > 59)
            System.out.println("Incorrect time!");
        else
            System.out.println("The time is " + hour + ":" + min + " now.");
    }
}
