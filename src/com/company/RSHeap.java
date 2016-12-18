package com.company;

/*
 *
 * HINT:
 *
 * last parent = (index - 1) / 2
 * left child = (index * 2) + 1
 * right child = (index * 2) + 2
 *
 */


/**
 * Replacement Selection Heap
 * Created by S1mpler on 12/15/2016.
 */
public class RSHeap {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    final int H;
    int[] array;

    int[] deadSpace;

    int[] inputBuffer;
    int[] outputBuffer;

    /**
     * Types of the heap.
     * MIN  -   insures that node's children will always >= their parent.
     * MAX  -   insures that node's children will always <= their parent.
     */
    enum Type {MIN, MAX};

    /**
     * Constructor
     * @param size Size of the heap
     */
    public RSHeap(int size) {
        this.H = size;
    }

    /**
     * Contsructor
     * @param size Size of the heap
     * @param numbers Array of integers
     */
    public RSHeap(int size, int[] numbers) {
        this.H = size;
        setArray(numbers);
    }

    /**
     * Setting array for the heap.
     * @param array Array of integers
     */
    public void setArray(int[] array) {
        if (array.length > H) {   //if amount of input array is larger then size of the heap.
            System.out.println("Error! Amount of array must be <= " + H
                    + "\nYou gave an array that contains " + array.length + " parameters");
        } else {    //if the length of input array is OK
            this.array = array;
        }
    }

    /**
     * Building the heap tree
     * @param type MIN heap or MAX heap type
     */
    public void build(Type type) {
        switch (type) {
            case MAX:
                buildMax();
                break;
            case MIN:
                buildMin();
                break;
        }
    }

    /**
     * Helper method.
     * Building the heap as a minHeap
     */
    private void buildMin() {
        // TODO: 12/18/2016 implement
    }

    /**
     * Helper method.
     * Building the heap as a maxHeap
     */
    private void buildMax() {
        for (int i = (array.length / 2) - 1; i >= 0; i--) {
           percolateDown(i);
        }
    }

    /**
     * Get the largest element out of two
     * @param i1 Index of the first element
     * @param i2 Index of the second element
     * @return The index of the largest element.
     */
    private int getTheLargest(int i1, int i2) {
        return array[i1] >= array[i2] ? i1 : i2;
    }

    /**
     * Get left child of the parent
     * @param index Index of the parent
     * @return Return index of the left child
     */
    private int getLeftChild(int index) {
        return (index * 2) + 1;
    }

    /**
     * Get right child of the parent
     * @param index Index of the parent
     * @return Return index of the right child
     */
    private int getRightChild(int index) {
        return (index * 2) + 2;
    }

    /**
     * Swap two heap nodes
     * @param i1 Index of the first node
     * @param i2 Index of the second node
     */
    private void swap(int i1, int i2) {
        int temporary = array[i1];
        array[i1] = array[i2];
        array[i2] = temporary;
    }

    /**
     * Percolate down method.
     */
    private void percolateDown(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int largestChild;

        if (rightChild < array.length) {
            //right child exists
            largestChild = getTheLargest(leftChild, rightChild);
        } else if(leftChild < array.length) {
            //if node has only one child then this child is the largest
            largestChild = leftChild;
        } else { //if this note is not a parent
            return;
        }

        if (array[largestChild] > array[index]) { // if the largest is larger then parent
            swap(largestChild, index);
            percolateDown(largestChild);
        }

    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + ", ";
        }
        return result;
    }
}
