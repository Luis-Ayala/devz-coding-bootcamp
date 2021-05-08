package com.devz.coding.bootcamp.problem3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HRTest {
    private static HR hr = null;
/*
    100              200              500
 *4*   *7*       *8* *9* *1*       *1*  *2*
  1     2         3   4   5        400   9
                                   *2*
                                    8
                                 *6* *7*
                                 10  11

*#* -> Cost from manager to employee
 */
    @BeforeAll
    public static void init() throws IOException {
        hr = new HR();

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(HRTest.class.getClassLoader().getResourceAsStream("employees"))))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] data = line.split(",");
                hr.build(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
        }
    }

    @Test
    void getTotalCost() {
        assertEquals(10, hr.getTotalCost());
    }
}