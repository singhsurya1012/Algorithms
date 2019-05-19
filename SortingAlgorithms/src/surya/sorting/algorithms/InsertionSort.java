package surya.sorting.algorithms;

import java.util.List;

import surya.sorting.main.Sorter;

public class InsertionSort implements Sorter{

	/**
	 * The main logic behind insertion sort is to break array into sorted and unsorted section
	 * first the zeroth element will belong to sorted section and the rest to unsorted section
	 * we take the first element in unsorted section and compare with the sorted section and place accordingly
	 * move to the next element in unsorted section
	 * repeat this process till we reach the end of unsorted section
	 */


	@Override
	public void sortArray(int[] arr) {

		//Loop over the unsorted section
		for (int i = 1; i < arr.length; i++) {
			int j = i-1; //Last element of the sorted section
			int toBeSortedValue = arr[i];
			while(j>=0 && arr[j] > toBeSortedValue) {
				arr[j+1] = arr[j];  //Here we move the sorted element to the next element
				j--; //Compare the to be sorted value with the previous sorted element
			}
			arr[j+1] = toBeSortedValue; //Place the sorted value in the appropriate position
		}
	}

	@Override
	public void sortList(List<Integer> list) {

		for (int i = 1; i < list.size(); i++) {
			int j = i-1; 
			int toBeSortedValue = list.get(i);
			while(j>=0 && list.get(j) > toBeSortedValue) {
				list.set(j+1, list.get(j));
				j--;
			}
			list.set(j+1, toBeSortedValue);
		}
	}



}
