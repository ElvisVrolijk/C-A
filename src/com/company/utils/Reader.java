package com.company.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Helper class for file reading.
 */
public class Reader {

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private List<String> lines;
    private String fileName;

    /**
     * Constuctor
     * @param fileName Name of the file to be read
     */
    public Reader(String fileName) throws IOException {
        this.lines = new ArrayList<>();
        this.fileName = fileName;
    }

    public List<String> getLines(int from, int amount) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int counter = 0;
        String line = reader.readLine();

        while (line != null && counter < (from + amount) - 1) {
            counter++;
            if (counter - from >= 0) {
                lines.add(line);
                line = reader.readLine();
            } else {
                line = reader.readLine();
            }
        }
        return lines;
    }
}
