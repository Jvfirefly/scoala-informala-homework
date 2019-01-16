package ro.sci.teo.ian14;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**Questions:
         * Cum fac ca id-ul produselor sa fie unic?
         * Tu ai folosi vreo interfata aici?
         *
         * alte neclaritati sunt scrise mai jos
         */


        //aici am testat daca merge sa introduc produse
        Product p = new VegetalProduct("001", "egg", 0.52, "2019-01-20", 3.5,
                2, new String[]{"A", "B"});
        //Stringul[] cu vitamine nu stiu daca e ok, pentru ca in cerinta scrie ceva de "list of vitamins"
        //sa folosesc ArrayList sau List?
        System.out.println(p.toString());


        System.out.println("-----------------------------------------------");
        System.out.println("1. Create product and add it to stock (press 1)");
        System.out.println("2. Sell product (press 2)");
        System.out.println("3. Display daily sales report (press 3)");
        System.out.println("4. Exit (press 4)");
        System.out.print("\nChose an option: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("-----------------------------------------------");

        switch (n) {
            case 1:
                System.out.println("Product type (1 - animal; 2 - vegetable): ");
                System.out.println("-----------------------------------------------");
                int prodType=sc.nextInt();
                if(prodType==1)
                    //got to createAnimalProduct();
                else if(prodType==2)
                        //got to createVegetalProduct();
                     else System.out.println("Error: Only 1 or 2 were possible options!");
                break;
            case 2:
                //sell product
                //aici am nevoie de o noua clasa numita order?
                break;
            case 3:
                //sales report from a specific date
                break;
            case 4:
                System.out.println("Have a nice day!");
                break;
            default:
                // code to be executed if n doesn't match any constant
                System.out.println("You should have entered a number between 1 and 4.");
        }
    }

}
