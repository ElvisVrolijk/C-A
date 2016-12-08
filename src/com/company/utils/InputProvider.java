package com.company.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by e_voe_000 on 12/8/2016.
 */
public class InputProvider {

    private Scanner reader;

    public int[] readFile(String fileName, int size) {
        int[] array = new int[size];
        try {
            reader = new Scanner(new FileReader(fileName));
            int i = 0;
            while ( reader.hasNextLine()) {
                array[i] = reader.nextInt();
                i++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return array;
    }
}
