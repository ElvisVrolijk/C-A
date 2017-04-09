package com.company.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S1mpler on 4/9/2017.
 */
public class Translator {

    /**
     * Translates list of String(s) to list of Integer(s)
     * @param lines List of String values
     * @return List of integers
     */
    public static int[] translateToIntArray(List<String> lines) {
        int[] numbers = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            numbers[i] = Integer.parseInt(lines.get(i));
        }
        return numbers;
    }

}
