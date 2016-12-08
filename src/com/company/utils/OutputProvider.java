package com.company.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Provides functions to manipulate output into the files.
 * Created by e_voe_000 on 12/8/2016.
 */
public class OutputProvider {

    /**
     * Method for file initialization.
     * @param filename Name of the file user wants to create
     * @param numbers Array of integers that file will contain
     */
    public void initFile(String filename, int[] numbers) {
        try{
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (int i = 0; i < numbers.length; i++) {
                writer.println(numbers[i]);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the content of the file
     * @param filename Name of the file user wants to clear
     */
    public void clearFile(String filename) {
        try {
            new PrintWriter(filename).close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
