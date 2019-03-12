package ro.sci.teo.mar06;

/**
 * This is the Main class from where the application can be launched.
 *
 * @author Teo
 */
public class Main {
    public static void main(String[] args) {
        Playground playground = new Playground();

        playground.runApp("input.csv", 6, "output1.csv");
        playground.runApp("input.csv", 12, "output2.csv");

        System.out.println();
        playground.runApp("input.csv", 0, "output1.csv");
        playground.runApp("input.csv", 13, "output1.csv");
        playground.runApp("in.csv", 6, "output1.csv");
    }
}
