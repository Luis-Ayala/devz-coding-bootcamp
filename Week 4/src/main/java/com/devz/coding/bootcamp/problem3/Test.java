package com.devz.coding.bootcamp.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Test {

    public static void main(String... a) throws IOException {
        HR hr = new HR();

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(Test.class.getClassLoader().getResourceAsStream("employees"))))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] data = line.split(",");
                hr.build(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
        }

        System.out.println(hr.getTotalCost());
        System.out.println("");
    }
}
