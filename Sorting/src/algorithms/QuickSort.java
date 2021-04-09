package algorithms;


import main.Sort;

import java.util.List;

public class QuickSort implements Sort {

	
	/**
	 * Quick sort algorithm selects a pivot value and places it correctly in the array
	 * all the element left to the pivot are smaller
	 * all the element right to the pivot are larger
	 * repeat the same procedure till all the elements are placed correctly in the array
	 * 
	 */
	@Override
	public void sortArray(int[] arr) {
		
		quickSortArray(arr,0,arr.length-1);
	}

	private void quickSortArray(int[] arr, int start, int end) {

		if(start<end) {
			//finding the index position of the pivot
			int pivot = partitionArray(arr,start,end);
			//sorting the left part of the array
			quickSortArray(arr, start, pivot-1);
			//sorting the right part of the array
			quickSortArray(arr, pivot+1,end);
		
		}
		
		
	}

	private int partitionArray(int[] arr, int start, int end) {
		//choosing the last index as pivot value
		int pivotValue = arr[end];
		int i=start-1;
		
		for (int j = start; j <= end; j++) {
			
			if(arr[j]<=pivotValue) {
				//increase the i index and swap the value with j position
				i++;
				int temp = arr[i];
				arr[i]= arr[j];
				arr[j] = temp;
			}
		}
				
				
		return i;
	}

	@Override
	public void sortList(List<Integer> list) {

		quickSortList(list,0,list.size()-1);

	}

	private void quickSortList(List<Integer> list, int start, int end) {
		
		if(start<end) {
			//finding the index position of the pivot
			int pivot = partitionList(list,start,end);
			//sorting the left part of the array
			quickSortList(list, start, pivot-1);
			//sorting the right part of the array
			quickSortList(list, pivot+1,end);
		
		}
	}

	private int partitionList(List<Integer> list, int start, int end) {
		int pivotValue = list.get(end);
		int i=start-1;
		
		for (int j = start; j <= end; j++) {
			
			if(list.get(j)<=pivotValue) {
				//increase the i index and swap the value with j position
				i++;
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
				
		return i;
	}

}
