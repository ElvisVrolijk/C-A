package com.company.utils;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Provides functions to manipulate output into the files.
 * Created by e_voe_000 on 12/8/2016.
 */
public class Writer {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private String fileName;

    /**
     * Constuctor
     * @param fileName Name of the file
     */
    public Writer(String fileName) {
        this.fileName = fileName;
    }


    /**
     * Method for filling file with numbers
     * @param numbers Array of integers that file will contain
     */
    public void fillFile(int[] numbers) {
        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            for (int number : numbers) {
                writer.println(number);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
