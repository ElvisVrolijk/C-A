package com.company.utils;

import java.util.ArrayList;

/**
 * Created by e_voe_000 on 12/17/2016.
 */
public class Heap {

    private int[] array;
    private int n;
    private int left;
    private int right;
    private int largest;

    private void buildHeap(int[] array) {
        n = array.length - 1;

        for (int i = n / 2; i >= 0; i--) {
            maxHeap(array, i);
        }
    }

    private void maxHeap(int[] array, int i) {
        left = 2 * i;
        right = 2 * i + 1;

        if (left <= n && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeap(array, largest);
        }

    }

    private void swap(int i, int j) {
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public void sort(int[] unsortedArray) {
        array = unsortedArray;
        buildHeap(array);

        for (int i = n; i > 0; i--) {
            swap(0, i);
            n = n - 1;
            maxHeap(array, 0);
        }


    }


}
