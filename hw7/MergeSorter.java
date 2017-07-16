package mergesort;

import java.util.Arrays;

/**
 * Descending Merge Sorter of ints. (High to low)
 * Mergesort is O(n*log(n)) 
 * @author Ricky Singh
 *
 */
public class MergeSorter {

	private int[] array;
	
	/**
	 * Constructor takes an array of ints to be sorted
	 * @param array
	 */
	public MergeSorter(int[] array){
		this.array = array;
	}
	
	/**
	 * The only public method of MergeSorter.
	 * Sorts the array from lowest to highest using merge sort,
	 * then reverses the array,
	 * then returns the array
	 * @return array
	 */
	public int[] sort(){
		mergeSort(array);
		reverse(array);
		return array;
	}
	
	/**
	 * Merges the two arrays left from mergeSort in order
	 * @param left
	 * @param right
	 * @param arr the orginal array
	 */
	private static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }
	
	/**
	 * Optional method to reverse the order of the array, 
	 * to go from highest to lowest
	 * @param data
	 */
	private static void reverse(int[] data) {
	    for (int left = 0, right = data.length - 1; left < right; left++, right--) {
	        int temp = data[left];
	        data[left]  = data[right];
	        data[right] = temp;
	    }
	}

	/**
	 * Recursive method to sort the array
	 * @param unsorted
	 */
	private static void mergeSort(int[] unsorted){
		if (unsorted.length == 1){
			return;
		}
		int[] leftHalf = Arrays.copyOfRange(unsorted, 0, unsorted.length/2);
		int[] rightHalf =  Arrays.copyOfRange(unsorted, (unsorted.length/2), unsorted.length);
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		merge(leftHalf, rightHalf, unsorted);
		
	}
	
	public static void main (String args[]){
		int[] a = {3, 4, 4, 6, 1, 2, 6, 3, 7, 8}; //array with even number of elements
		int[] b = {3, 5, 4, 4, 6, 1, 2, 6, 3, 7, 8}; //array with odd number of elements
		int[] c = {-3454, 1, 0, 9, 9, 9, 9, 9, 9, 244345};
		MergeSorter r = new MergeSorter(c);
		MergeSorter m = new MergeSorter(a);
		MergeSorter n = new MergeSorter(b);
		System.out.println(Arrays.toString(m.sort()));
		System.out.println(Arrays.toString(n.sort()));
		System.out.println(Arrays.toString(r.sort()));

	}
}
