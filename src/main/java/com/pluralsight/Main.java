package com.pluralsight;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    public static void LedgerList() {

            try {
                BufferedReader br = new BufferedReader(new FileReader("Transactions.csv"));
                //This creates a new instance of a list
                //The hashmap is a container is the dataType! Sting, int, double, boolean, Class
                ArrayList<accountingApp> list = new ArrayList<>();
                String line;
                //This tells the date what to parse into! Then it will convert the date into a string!


                while ((line = br.readLine())!= null) {
                //We need to create an object to add to the list!
                    //Accounting app has all of our data! Therefore we need to call on it to create a new instance
                    accountingApp loadList = new accountingApp();
                    String[] tempArray = line.split(Pattern.quote("|"));
                    //
                    try {
                        //This turns the string into a double!
                        LocalDate dateTemp = LocalDate.parse(tempArray[0]);
                        LocalTime timeTemp = LocalTime.parse(tempArray[1]);
                        String tempDescription = tempArray[2];
                        String tempVendor = tempArray[3];
                        double amountTemp = Double.parseDouble(tempArray[4]);

                        //This sets the double into our object!
                        loadList.setDate(dateTemp);
                        loadList.setTime(timeTemp);
                        loadList.setDescription(tempDescription);
                        loadList.setVendor(tempVendor);
                        loadList.setAmount(amountTemp);

                        //This permanately adds our instance into the list we made earlier
                        list.add(loadList);
                    }
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }


                }

            } catch (FileNotFoundException e) {
                System.out.println("file not found");
                e.printStackTrace();

            } catch (IOException e) {
                System.out.println("Something went wrong");
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
            System.out.print("Make a selection ");
            int choice = uKey.nextInt();
            uKey.nextLine();

            switch (choice) {
                case 1:
                    addDeposit();
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
        boolean run = true;
        formattedSpace();
        while (run) {
            System.out.println("\t(1) Display all");
            System.out.println("\t(2) Show deposits");
            System.out.println("\t(3) Show payments");
            System.out.println("\t(4) Show reports");
            System.out.println("\t(0) back to homepage");

            System.out.print("Please select your option ");
            int choice = uKey.nextInt();

            switch (choice) {
                case 1:
                    displayLedger();
                    break;
                case 2:
                    depositEntry();
                    break;
                case 3:
                    paymentDisplayLedger();
                    paymentEntry();
                    break;
                case 4:
                    reports();
                    break;
                case 0:
                    homeScreen(uKey);
                    break;
                default:
                    waitAndGo(uKey,"invalid inout try again");

            }


        }



    }

    public static void addDeposit() {
        LedgerList();

    }

    public static void paymentDebit(Scanner uKey) {

    }
    //positive balances
    public static void depositEntry() {
        LedgerList();

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
