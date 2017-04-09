package com.company.model;

/**
 * Representation of a heap.
 *
 * HINT:
 * last parent = (index - 1) / 2
 * left child = (index * 2) + 1
 * right child = (index * 2) + 2
 *
 */
public class Heap {
    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private int size;
    private int[] heap; //deadspace is inside of this heap

    int[] inputBuffer;
    int[] outputBuffer;

    /*
     * Type of the heap.
     * MAX  -   insures that node's children will always <= their parent.
     */

    /**
     * Constructor
     * @param size Size of the heap
     */
    Heap(int size) {
        this.size = size;
    }

    /**
     * Setting heap for the heap.
     * @param heap Array of integers
     */
    public Heap setHeapArray(int[] heap) {
        if (heap.length > size) {   //if amount of input heap is larger then size of the heap.
            System.out.println("Error! Heap size is " + size
                    + "\nYou gave an heap that contains " + heap.length + " parameters");
        } else {    //if the length of input heap is OK
            this.heap = heap;
        }
        return this;
    }

    /**
     * Builds a MAX heap
     */
    public void build() {
        buildMax();
    }

    /**
     * Helper method.
     * Building the heap as a maxHeap
     */
    private void buildMax() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * Removes and returns top of the heap (max) and rebuilds the heap
     * @return Max (top) element of the heap
     */
    public int popMax() {
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        build();
        return max;
    }

    public int getDeadspaceLength() {
        return heap.length - size;
    }

    /**
     * Checks if the heap empty
     * @return True if heap is empty
     */
    private boolean isHeapEmpty() {
        return size == 0;
    }

    /**
     * Get the largest element out of two
     * @param i1 Index of the first element
     * @param i2 Index of the second element
     * @return The index of the largest element.
     */
    private int getTheLargest(int i1, int i2) {
        return heap[i1] >= heap[i2] ? i1 : i2;
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
        int temporary = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temporary;
    }

    /**
     * Percolate down method.
     */
    private void percolateDown(int index) {
        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);
        int largestChild;

        if (rightChild < size) {
            //right child exists
            largestChild = getTheLargest(leftChild, rightChild);
        } else if(leftChild < size) {
            //if node has only one child then this child is the largest
            largestChild = leftChild;
        } else { //if this note is not a parent
            return;
        }

        if (heap[largestChild] > heap[index]) { // if the largest is larger then parent
            swap(largestChild, index);
            percolateDown(largestChild);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += heap[i] + ", ";
        }
        return result;
    }
}
