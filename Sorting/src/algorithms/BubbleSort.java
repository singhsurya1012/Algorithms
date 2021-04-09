package algorithms;


import java.util.List;

public class BubbleSort implements Sort {

	/***
	 * Example in pseudo code, assuming a zero-indexed array:
	 * maintain a flag to check if there is any switching
	 * iterate over the array and compare with the next element and swap if next element is smaller
	 * make the flag true and repeat until a complete iteration where no elements are switched.
	 * Worst case performance = O(n^2)
	 * Best case performance = O(n)
	 */
	
	public void sortArray(int[] arr) {
		
		boolean numSwitched;
		int n = arr.length;
		do {
			numSwitched = false;
			//here we don't have to compare for the last element hence length-1 is used
			for(int i=0;i<n-1;i++) {
				if(arr[i] > arr[i+1]) {
					int temp =arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					numSwitched = true;
				}
			}
			n--;
		} while (numSwitched);
	}

	
	public void sortList(List<Integer> list) {

		boolean numSwitched;
		do {
			numSwitched = false;
			//here we don't have to compare for the last element hence length-1 is used
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i) > list.get(i+1)) {
					int temp =list.get(i+1);
					list.set(i+1, list.get(i));
					list.set(i, temp);
					numSwitched = true;
				}
			}

		} while (numSwitched);
	}


}
