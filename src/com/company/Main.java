package com.company;

import com.company.model.RSHeap;
import com.company.utils.Reader;
import com.company.utils.Translator;


public class Main {

    // TODO: 12/18/2016 implement file writer

    public static void main(String[] args) {
        Reader reader;
        try {
            reader = new Reader("Input.txt");

            int[] numbers = Translator.translateToIntArray(reader.getLines(5, 8));

            for (int number : numbers) {
                System.out.println(number);
            }

            System.out.println("------heap------");

            RSHeap heap = new RSHeap(numbers.length);
            heap.setHeapArray(numbers).build();
            System.out.println(heap);

//            numbers = reader.readLine(19);
//            for (int number : numbers) {
//                System.out.print(number + ", ");
//            }
//            System.out.println();
//            System.out.println("---sorted---");
//            RSHeap heap = new RSHeap(numbers.length, numbers);
//            heap.build(RSHeap.Type.MAX);
//            System.out.println(heap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
