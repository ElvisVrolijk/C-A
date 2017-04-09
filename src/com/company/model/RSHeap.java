package com.company.model;

/**
 * Replacement Selection Heap
 * Created by S1mpler on 12/15/2016.
 */
public class RSHeap extends Heap{

    /**
     * Constructor
     * @param size Size of the heap
     */
    public RSHeap(int size) {
        super(size);
    }

    public void sort() {
        replacementSelection();
        twoWaySorting();
    }

    private void replacementSelection() {
        // TODO: 4/9/2017 To be implemented
    }

    private void twoWaySorting() {
        // TODO: 4/9/2017 To be implemented
    }
}
