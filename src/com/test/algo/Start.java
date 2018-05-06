package com.test.algo;

public class Start {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5};
		int n = arr.length;

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n-1);
		
		BinarySearch bs = new BinarySearch();
        int x = 7;
        int result = bs.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at " + 
                                   "index " + result);

	}

}
