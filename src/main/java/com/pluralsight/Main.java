package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Where I'll put the core(?) stuff
        Scanner uKey = new Scanner(System.in);
       System.out.println("Home screen test welcome");
        homeScreen(uKey);
    }
    //initialization of the Ledger
    public static void displayLedger() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("src/main/resources/Transactions.csv"));
            String data;
            while((data = bufReader.readLine())!= null) {
                System.out.println(data);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("An error has occurred");

        }

    }

    public static void homeScreen(Scanner uKey){

        boolean run = true;

        while (run) {
            System.out.println("Selection page");
            System.out.println("\t1 Add Deposit");
            System.out.println("\t2 Make payment(debit)");
            System.out.println("\t3 Ledger page");
            System.out.println("\t0 Exit");
            int choice = uKey.nextInt();
            uKey.nextLine();

            switch (choice) {
                case 1:
                    //addDeposit
                    break;
                case 2:
                    paymentDebit(uKey);
                    break;
                case 3:
                    ledgerScreen(uKey);
                    break;
                case 0:
                    System.out.println("Stop by again, yah?");
                    uKey.close();
                    System.exit(0);
                    break;
                default:
                    waitAndGo(uKey, "Wrong option please try again");
            }

        }

    }

    public static void ledgerScreen (Scanner uKey) {
        System.out.println("Ledger page");
        uKey.nextLine();
        boolean run = true;
        while (run) {
            System.out.println("");
        }


    }

    public static void paymentDebit(Scanner uKey) {

    }
    //positive balances
    public static void depositEntry() {

    }

    //Negative balances
    public static void paymentEntry() {

    }

    public static void reports() {

    }

    public static void waitAndGo(Scanner ukey, String message) {
        System.out.println(message + "(press ENTER to continue");
        ukey.nextLine();
        formattedSpace();
    }

    public static void formattedSpace() {
        System.out.println("\n\n\n\n");
    }
}
