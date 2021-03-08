package surya.sorting.algorithms;

import java.util.List;

import surya.sorting.main.Sorter;

public class InPlaceMergeSort implements Sorter {

	/**
	 * Same as merge sort except that the merge part is done in place instead of using a temp array
	 * 
	 */
	
	@Override
	public void sortArray(int[] arr) {
		mergeSortArray(arr,0,arr.length-1);
	}

	private void mergeSortArray(int[] arr, int start, int end) {

		//base condition to check if there is a single element left 
		if(start>=end) {
			return;
		}

		int mid = (start+end)/2;
		//breaking the array into two half and calling the same function recursively
		mergeSortArray(arr, start, mid);
		mergeSortArray(arr, mid+1, end);
		//heart of the algorithm where the merging f two half takes place
		mergeArrayInPlace(arr,start,mid,end);
	}

	private void mergeArrayInPlace(int[] arr, int start, int mid, int end) {
		
		//Here we create two pointers one for left half and the other for right half
		int leftIndex = start;
		int rightIndex = mid+1;
		
		while(leftIndex<=mid && rightIndex<=end) {

			//if left half element is smaller then simply increase the left index
			if(arr[leftIndex] < arr[rightIndex]) {
				leftIndex++;

			}else {
				//if right half element is smaller then we have to move entire elements between left index and right index
				//copy the value before moving
				int value = arr[rightIndex];
				int index = rightIndex;
				
				while(index!=leftIndex) {
					arr[index] = arr[index-1];
					index--;
				}
				
				//Move right index value at the left position
				arr[index] = value;
				//increment all the indexes
				leftIndex++;
				rightIndex++;
				mid++;
			}
		}



	}

	@Override
	public void sortList(List<Integer> list) {
		mergeSortList(list,0,list.size()-1);

	}

	private void mergeSortList(List<Integer> list, int start, int end) {


		if(start>=end) {
			return;
		}

		int mid = (start+end)/2;
		mergeSortList(list, start, mid);
		mergeSortList(list, mid+1, end);
		mergeListInPlace(list,start,mid,end);
	}


	private void mergeListInPlace(List<Integer> list, int start, int mid, int end) {

		int leftIndex = start;
		int rightIndex = mid+1;

		while(leftIndex<=mid && rightIndex<=end) {

			if(list.get(leftIndex) < list.get(rightIndex)) {
				leftIndex++;
			}else {
				
				int value = list.get(rightIndex);
				int index = rightIndex;
				
				while(index!=leftIndex) {
					list.set(index, list.get(index-1));
					index--;
				}
				
				list.set(leftIndex, value);
				leftIndex++;
				rightIndex++;
				mid++;
						
			}
		}

	}

}
