package surya.sorting.main;

import java.util.List;

import surya.sorting.algorithms.QuickSort;

public class MainApp {

	public static void main(String[] args) {
		
		Sorter sorter = new QuickSort();
		
		
		List<Integer> list = Util.randomListGenerator(10,500,-500);
		int[] arr = Util.randomArrayGenerator(10,500,-500);
		
		System.out.println("Before Sorting List");
		Util.printList(list);
		
		System.out.println("After Sorting List");
		sorter.sortList(list);
		Util.printList(list);
		
		
		System.out.println("Before Sorting Array");
		Util.printArray(arr);
		
		
		System.out.println("After Sorting Array");
		sorter.sortArray(arr);
		Util.printArray(arr);
	}






	

}
