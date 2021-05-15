package com.devz.coding.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public static List<String> getValidBankingWindows(final int bankingWindows) {
        // store the valid banking windows
        final List<String> validBankingWindows = new ArrayList<>();

        // gets the max number or the number of banking windows (3 => 7 (111), 4 => 15 (1111)
        final char[] arrayMaxNumber = new char[bankingWindows];
        java.util.Arrays.fill(arrayMaxNumber, '1');
        final int maxNumber = Integer.parseInt(String.valueOf(arrayMaxNumber), 2);

        // flags, occupied determines if the bit position is 1 and
        // isValidBankingWindows is true if the number variable does not has two contiguous 1
        boolean occupied = false;
        boolean isValidBankingWindows = true;

        // analyze eac number from 0 to maxNumber
        for(int number = 0; number <= maxNumber; number++) {
            // compare each number's bit if there are two contiguous 1 the break and mark as no valid number.
            for(int bitPosition = 0; bitPosition < bankingWindows; bitPosition++) {
                final boolean isOccupied = ((number >> bitPosition) & 1) == 1;
                if(isOccupied && occupied) {
                    isValidBankingWindows = false;
                    break;
                }
                occupied = isOccupied;
            }
            // if os valid then add its string representation to the list.
            if(isValidBankingWindows)
                validBankingWindows.add(
                        String.format("%0" + bankingWindows + "d",
                                Integer.valueOf(Integer.toBinaryString(number))));

            // reset flags for the next number.
            isValidBankingWindows = true;
            occupied = false;
        }

        return validBankingWindows;
    }
}
