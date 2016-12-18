package com.company;

import com.company.utils.FileReader;


public class Main {

    // TODO: 12/18/2016 implement file writer

    public static void main(String[] args) {
        FileReader reader;
        int[] numbers;
        try {
            reader = new FileReader("Input.txt");
            numbers = reader.readLine(19);
            for (int number : numbers) {
                System.out.print(number + ", ");
            }
            System.out.println();
            System.out.println("---sorted---");
            RSHeap heap = new RSHeap(numbers.length, numbers);
            heap.build(RSHeap.Type.MAX);
            System.out.println(heap);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
