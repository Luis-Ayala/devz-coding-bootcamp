package com.devz.coding.bootcamp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PascalTriangle {
    private static final Map<Integer, Integer[]> cachedRows = new HashMap<>();

    public Integer[] getRowCoefficients(final int rowIndex) {
        if(cachedRows.containsKey(rowIndex))
            return cachedRows.get(rowIndex);
        else {
            final int maxKey = cachedRows.isEmpty() ? 0 : Collections.max(cachedRows.keySet()) + 1;
            for(int row = maxKey; row <= rowIndex; row++) {
                cachedRows.put(row, getRow(row));
            }
        }

        return cachedRows.get(rowIndex);
    }

    private Integer[] getRow(final int rowIndex) {
        if(rowIndex == 0)
            return new Integer[] { 1 };

        if(rowIndex == 1)
            return new Integer[] { 1, 1 };

        // create a new array with length rowIndex + 1
        final Integer[] row = new Integer[rowIndex + 1];

        // fill the first position and the last with 1
        row[0] = 1;
        row[row.length - 1] = 1;

        // gets the previous row from the list of rows
        final Integer[] previousRow = cachedRows.get(rowIndex - 1);

        // fills the row from position 1 to length - 2 (the first and last positions are always 1)
        for(int index = 1; index <= row.length - 2; index++) {
            row[index] = previousRow[index - 1] + previousRow[index];
        }

        return row;
    }
}
