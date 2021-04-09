package algorithms;


import main.Sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {

    /**
     * In merge sort me break the array into two half until there is single element left
     * Then me start merging the two half such that the resulting new half is sorted
     * Worst case peformance = O(nlogn)
     */

    @Override
    public void sortArray(int[] arr) {
        mergeSortArray(arr, 0, arr.length - 1);
    }

    private void mergeSortArray(int[] arr, int start, int end) {

        //base condition to check if there is a single element left
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        //breaking the array into two half and calling the same function recursively
        mergeSortArray(arr, start, mid);
        mergeSortArray(arr, mid + 1, end);
        //heart of the algorithm where the merging of two half takes place
        mergeArray(arr, start, mid, end);
    }

    private void mergeArray(int[] arr, int start, int mid, int end) {

        //Here we create two pointers one for left half and the other for right half
        int leftIndex = start;
        int rightIndex = mid + 1;

        // If the direct merge is already sorted
        if (arr[mid] <= arr[rightIndex]) {
            return;
        }

        //creating a temp array to store the sorted array
        int[] tempArr = new int[end - start + 1];
        int k = 0;

        while (leftIndex <= mid && rightIndex <= end) {

            //if left half element is greater adding the right half element in temp arr and increasing the right index
            if (arr[leftIndex] > arr[rightIndex]) {
                tempArr[k] = arr[rightIndex];
                rightIndex++;

            } else {
                tempArr[k] = arr[leftIndex];
                leftIndex++;
            }
            k++;
        }


        //It is possible that the left or the right part of the array has not been traversed fully
        if (leftIndex <= mid) {
            while (leftIndex <= mid) {
                tempArr[k] = arr[leftIndex];
                k++;
                leftIndex++;
            }
        } else if (rightIndex <= end) {
            while (rightIndex <= end) {
                tempArr[k] = arr[rightIndex];
                k++;
                rightIndex++;
            }

        }

        //copying the array back into original array
        for (int i = 0; i < tempArr.length; i++) {
            arr[start + i] = tempArr[i];
        }

    }

    @Override
    public void sortList(List<Integer> list) {
        mergeSortList(list, 0, list.size() - 1);

    }

    private void mergeSortList(List<Integer> list, int start, int end) {


        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortList(list, start, mid);
        mergeSortList(list, mid + 1, end);
        mergeList(list, start, mid, end);
    }


    private void mergeList(List<Integer> list, int start, int mid, int end) {

        int leftIndex = start;
        int rightIndex = mid + 1;
        int k = 0;
        List<Integer> tempList = new ArrayList<>();


        if (list.get(mid) <= list.get(rightIndex)) {
            return;
        }

        while (leftIndex <= mid && rightIndex <= end) {

            if (list.get(leftIndex) > list.get(rightIndex)) {
                tempList.add(list.get(rightIndex));
                rightIndex++;

            } else {
                tempList.add(list.get(leftIndex));
                leftIndex++;
            }
            k++;
        }


        if (leftIndex <= mid) {
            while (leftIndex <= mid) {
                tempList.add(list.get(leftIndex));
                k++;
                leftIndex++;
            }
        } else if (rightIndex <= end) {
            while (rightIndex <= end) {
                tempList.add(list.get(rightIndex));
                k++;
                rightIndex++;
            }
        }

        for (int i = 0; i < tempList.size(); i++) {
            list.set(start + i, tempList.get(i));
        }
    }

}
