package main;


import algorithms.QuickSort;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Sort sort = new QuickSort();


        List<Integer> list = Util.randomListGenerator(10, 500, -500);
        int[] arr = Util.randomArrayGenerator(10, 500, -500);

        System.out.println("Before Sorting List");
        Util.printList(list);

        System.out.println("After Sorting List");
        sort.sortList(list);
        Util.printList(list);


        System.out.println("Before Sorting Array");
        Util.printArray(arr);


        System.out.println("After Sorting Array");
        sort.sortArray(arr);
        Util.printArray(arr);
    }


}
