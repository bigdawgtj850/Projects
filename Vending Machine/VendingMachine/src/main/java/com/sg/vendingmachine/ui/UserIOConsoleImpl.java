package com.sg.vendingmachine.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author ShantelJ
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner scn = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void println(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Double.parseDouble(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number. ");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double input = readDouble(prompt);
        while (!(min <= input && input <= max)) {
            print("Error: number out of range.");
            input = readDouble(prompt);
        }

        return input;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Float.parseFloat(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        Float input = readFloat(prompt);
        while (!(min <= input && input <= max)) {
            print("Error: number out of range.");
            input = readFloat(prompt);
        }

        return input;
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number.");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int input = readInt(prompt);
        while (!(min <= input && input <= max)) {
            println("Error: number out of range.");
            input = readInt(prompt);
        }

        return input;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            print(prompt);
            try {
                return Long.parseLong(scn.nextLine());
            } catch (NumberFormatException e) {
                println("Please enter a valid number.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long input = readLong(prompt);
        while (!(min <= input && input <= max)) {
            print("Error: number out of range.");
            input = readLong(prompt);
        }

        return input;
    }

    /**
     *
     * @param prompt
     * @return the first character of the entered string, discarding the rest of
     * the line
     */
    @Override
    public char readChar(String prompt) {
        String str;
        print(prompt);

        while (true) {
            str = scn.nextLine();

            if (!str.equals("")) {
                return str.charAt(0);
            }
            print("Invalid response, please enter a single character: ");
        }

    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        return scn.nextLine();
    }
    
    @Override
    public BigDecimal readCurrency(String prompt) {
        String str;
        print(prompt);
        
        while(true) {
            str = scn.nextLine();
            
            if(str.matches("\\d*\\.\\d{0,2}")) return new BigDecimal(str);
            print("Please enter currency in the form 'dollars.cents'");
        }
    }

}