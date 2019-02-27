package ro.sci.teo.feb11.time;

import java.util.InputMismatchException;
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
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("What time is it?");
            System.out.print("Enter the hour: ");
            int h = sc.nextInt();
            System.out.print("Enter the minute: ");
            int minute = sc.nextInt();

            if (!new TimeCheck().validateTime(h, minute))
                System.out.println("Incorrect time!");
            else if (h < 10)
                if (minute < 10)
                    System.out.println("The time is 0" + h + ":0" + minute + " now.");
                else
                    System.out.println("The time is 0" + h + ":" + minute + " now.");
            else if (minute < 10)
                System.out.println("The time is " + h + ":0" + minute + " now.");
            else
                System.out.println("The time is " + h + ":" + minute + " now.");
        } catch (InputMismatchException e) {
            System.out.println("All program arguments should be natural numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("The hour or the minute is not valid.");
        }
    }

    public boolean validateTime(int hour, int min) throws IllegalArgumentException {
        if (hour < 0 || hour > 23 || min < 0 || min > 59) {
            //return false;
            throw new IllegalArgumentException("");
        }
        return true;
    }
}
