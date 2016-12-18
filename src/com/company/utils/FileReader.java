package com.company.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Helper class for file reading.
 */
public class FileReader {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    String fileName;
    private final File file;
    private final List<String> lines;


    /**
     * Constuctor
     *
     * @param fileName
     */
    public FileReader(String fileName) throws IOException {
        this.fileName = fileName;
        file = new File("Input.txt");

        lines = FileUtils.readLines(file);
    }

    /**
     * Reads the line at the index.
     *
     * @param index the line to be read.
     * @return an array of numbers given by the index.
     * @throws Exception
     */
    public int[] readLine(int index) throws Exception {
        String line = lines.get(index);
        int[] result;

        if (line.matches("^\\[(((\\s|)(-|)\\d+|(((\\s|)(-|)\\d+),)+(\\s|)(-|)\\d)+)]$")) {
            String stringIntegers = line.replaceAll("\\[|]|\\s", "");


            String[] integers = stringIntegers.split(",");

            result = new int[integers.length];

            for (int i = 0; i < integers.length; i++) {
                result[i] = Integer.parseInt(integers[i]);
            }

            return result;
        }
        throw new Exception("Line at " + index + " is not an array.");
    }

    /**
     * Read fixed amount of numbers from the file
     *
     * @param size Amount of numbers to read
     * @return Array of integers
     */
    public int[] readNumbers(int size) {
        int[] result = new int[size];

        return result;
    }
}
