package com.devz.coding.bootcamp;

import java.util.*;

public class PascalTriangle {

    private static final Map<Integer, Integer[]> cachedRows = new HashMap<>();

    public static void main(String... args) {
        final PascalTriangle pascal = new PascalTriangle();
        pascal.calculatePascalTriangle();
    }

    private void calculatePascalTriangle() {
        System.out.println("Enter a integer digit in order to get the Pascal triangle coefficients (-1 to stop):");
        int rowIndex = -1;
        Scanner input = new Scanner(System.in);
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

            System.out.println(Arrays.toString(getRowCoefficients(rowIndex)));
        }

        input.close();
    }

    private Integer[] getRowCoefficients(final int rowIndex) {
        if(cachedRows.containsKey(rowIndex))
            return cachedRows.get(rowIndex);
        else {
            int maxKey = cachedRows.isEmpty() ? 0 : Collections.max(cachedRows.keySet()) + 1;
            for(int row = maxKey; row <= rowIndex; row++) {
                final Integer[] coefficients = getRow(row);
                cachedRows.put(row, coefficients);
            }
        }

        return cachedRows.get(rowIndex);
    }

    private Integer[] getRow(final int level) {
        if(level == 0)
            return new Integer[] { 1 };

        if(level == 1)
            return new Integer[] { 1, 1 };

        // create a new array with length level + 1
        final Integer[] row = new Integer[level + 1];

        // fill the first position and the last with 1
        row[0] = 1;
        row[row.length - 1] = 1;

        // gets the previous row from the list of rows
        //final Integer[] previousRow = rows.get(level - 1);
        final Integer[] previousRow = cachedRows.get(level - 1);

        // fills the row from position 1 to length - 2 (the last position is always 1)
        for(int index = 1; index <= row.length - 2; index++) {
            row[index] = previousRow[index - 1] + previousRow[index];
        }

        return row;
    }
}
