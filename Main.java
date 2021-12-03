package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Products> products = new ArrayList<Products>();
        // Populating the array list with products and prices
        Products prod1 = new Products();
        Products prod2 = new Products();
        Products prod3 = new Products();
        Products prod4 = new Products();

        prod1.setProd("Bison Sweater");
        prod1.setPrice(55.99);
        products.add(prod1);

        prod2.setProd("Bison Tee");
        prod2.setPrice(14.99);
        products.add(prod2);

        prod3.setProd("Bison Hoodie");
        prod3.setPrice(23.99);
        products.add(prod3);

        prod4.setProd("Bison Bumpersticker");
        prod4.setPrice(4.99);
        products.add(prod4);

        String answer = "";
        ArrayList<Products> purchases= new ArrayList<Products>();

        // Starting dowhile. Prompting user input to access
        do {
            System.out.println("What do you want to do?");
            System.out.println("1) add purchase 2) change purchase 3) show purchase(s) 4) finish transaction");
            answer = keyboard.nextLine();
            if (answer.equals("1")) {
                System.out.println("What do you wish to buy?");
                answer = keyboard.nextLine();
                Products newprod = new Products();
                newprod.setProd(answer);
                purchases.add(newprod);
            }
            // altering change purchases loop
            if (answer.equals("2")) {
                System.out.println("What do you wish to change? Enter the name of the item.");
                for (int i = 0; i < purchases.size(); i++) {
                    System.out.println(purchases.get(i).getProd());
                }
                answer = keyboard.nextLine();
                System.out.println("What would you like to change it to? Enter the name of the item.");
                String exchange = keyboard.nextLine();

                // Search the purchase list to see if answer matches
                for (int i = 0; i < purchases.size(); i++) {
                    if (answer.equals(purchases.get(i).getProd())) {
                        purchases.get(i).setProd(exchange);
                    }
                }
            }
            if (answer.equals("3")) {
                System.out.println("Which purchase would you like to see?");
                for (int i = 0; i < purchases.size(); i++) {
                    System.out.println(purchases.get(i).getProd());
                }
                // looping through products list to output matching product and price
                answer = keyboard.nextLine();
                for (int i = 0; i < products.size(); i++) {
                    if (answer.equals(products.get(i).getProd())) {
                        System.out.println("Product: " + products.get(i).getProd() + " | Price: " + products.get(i).getPrice());
                    }
                }
            }
        } while (! answer.equals("4"));

        double totalcost = 0.0;
        int j = 0;
        for (int i = 0; i < purchases.size(); i++) {
            for (j = 0; j < products.size(); j++) {
                // condition is check if the value in purchases at position i is equal to the value in products at position j
                if ( purchases.get(i).getProd().equals(products.get(j).getProd())) {
                    // increment totalcost with the ith value in the prices array
                    totalcost += products.get(j).getPrice();
                }
            }
        }
        System.out.println("Total Cost: " + totalcost);
    }
}
