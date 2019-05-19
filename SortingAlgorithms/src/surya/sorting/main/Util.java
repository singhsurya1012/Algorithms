package surya.sorting.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	private static Random random = new Random();
	
	public static int[] randomArrayGenerator(int size,int upperbound, int lowerBound) {

		int [] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(upperbound+ 1 - lowerBound) + lowerBound;
		}

		return array;
	}


	public static List<Integer> randomListGenerator(int size,int upperbound, int lowerBound) {

		List<Integer> list	= new ArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			list.add(random.nextInt(upperbound + 1 -lowerBound) + lowerBound);
		}
		
		return list;
	}
	
	
	public static void printArray(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]);
			System.out.print(" --> ");			
		}
		System.out.println();
	}
	
	public static void printList(List<Integer> list) {
		
		for (int i = 0; i < list.size(); i++) {
			
			System.out.print(list.get(i));
			System.out.print(" --> ");
			
		}
		System.out.println();
	}
	
	
}
