package surya.sorting.algorithms;

import java.util.List;

import surya.sorting.main.Sorter;

public class SelectionSort implements Sorter {

	/***
	 * In Selection sort every element is compared with the rest of the element to find minimum
	 * Once this is done we move the minimum to the first slot and continue with the next element
	 * Worst case performance = O(n^2)
	 */


	@Override
	public void sortArray(int[] arr) {

		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1; j <arr.length;j++) {

				if(arr[min]> arr[j]) {
					min = j;
				}

			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

	}

	@Override
	public void sortList(List<Integer> list) {

		for(int i=0;i<list.size()-1;i++) {
			int min = i;
			for(int j=i+1; j <list.size();j++) {

				if(list.get(min)> list.get(j)) {
					min = j;
				}

			}
			int temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}

	}

}
