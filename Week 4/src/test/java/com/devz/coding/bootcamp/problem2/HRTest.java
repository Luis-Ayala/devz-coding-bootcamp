package com.devz.coding.bootcamp.problem2;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class HRTest {
    private static HR hr = null;
/*
    100              200              500
  1     2         3   4   5        400   9
                                    8
                                 10  11
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
                hr.build(Integer.parseInt(data[0]), Integer.parseInt(data[1]));
            }
        }
    }

    @Test
    void isManager() {
        assertTrue(hr.isManager(8, 10));
        assertTrue(hr.isManager(8, 11));
        assertTrue(hr.isManager(400, 8));
        assertFalse(hr.isManager(500, 1));
    }

    @Test
    void isInManagementChain() {
        assertTrue(hr.IsInManagementChain(400, 11));
        assertTrue(hr.IsInManagementChain(500, 8));
        assertFalse(hr.IsInManagementChain(200, 10));
    }

    @Test
    void getSubEmployees() {
        assertArrayEquals(new int[] {400, 8, 11, 10, 9}, hr.getSubEmployees(500).stream().mapToInt(i->i).toArray());
        assertArrayEquals(new int[] {8, 11, 10}, hr.getSubEmployees(400).stream().mapToInt(i->i).toArray());
        assertArrayEquals(new int[] {11, 10}, hr.getSubEmployees(8).stream().mapToInt(i->i).toArray());
        assertArrayEquals(new int[] {}, hr.getSubEmployees(11).stream().mapToInt(i->i).toArray());
    }
}