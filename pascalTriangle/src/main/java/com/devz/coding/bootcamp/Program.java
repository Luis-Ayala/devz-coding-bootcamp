package com.devz.coding.bootcamp;

import java.util.*;

public class Program {

    /**
     * Entry point
     * @param args List of arguments, this program does not need inputs
     */
    public static void main(String... args) {
        Program program = new Program();
        program.calculatePascalTriangle();
    }

    private void calculatePascalTriangle() {
        final PascalTriangle pascal = new PascalTriangle();

        System.out.println("Enter an integer digit in order to get the Pascal triangle coefficients (-1 to stop):");
        int rowIndex = -1;
        final Scanner input = new Scanner(System.in);
        while(true) {
            try {
                rowIndex = input.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("The input is not a valid Integer. Provide a valid Integer:");
                continue;
            }

            if(rowIndex == -1) {
                break;
            }

            System.out.println(Arrays.toString(pascal.getRowCoefficients(rowIndex)));
        }

        input.close();
    }
}
