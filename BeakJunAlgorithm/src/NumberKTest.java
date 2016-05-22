import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class NumberKTest {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));

//		String[] inputConditions = sc.nextLine().split(" ");
//		int arrayLength = Integer.parseInt(inputConditions[0]);
//		int resultIndex = Integer.parseInt(inputConditions[1]);

		
		String[] inputConditions = bfReader.readLine().split(" ");
		int arrayLength = Integer.parseInt(inputConditions[0]);
		int resultIndex = Integer.parseInt(inputConditions[1]);
		int[] inputsArray = new int[arrayLength];
		
		String[] inputs = bfReader.readLine().split(" ");
		
		System.out.println(quickSelect(inputs, resultIndex));
		
		
//		for (int i = 0; i < arrayLength; i++) {
//			inputsArray[i] = sc.nextInt();
//			
//		}

		// quickSort(inputsArray, 0, arrayLength - 1);

//		quickSortPivotMedian(inputsArray, 0, arrayLength - 1);
//		for (int i = 0; i < arrayLength; i++) {
//			System.out.print(inputsArray[i] + " ");
//		}
//		System.out.println("");
//		System.out.println(inputsArray[resultIndex]);
		
		
//		System.out.println(quickSelect(inputsArray, resultIndex));
	}
	/**
	 * 네번째 시도
	 * 
	 * */
	private static int partition(String[] array, int left, int right, int pivot) {
		String pivotVal = array[pivot];
		swap(array, pivot, right);
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (Integer.parseInt(array[i])<Integer.parseInt(pivotVal)) {
				swap(array, i, storeIndex);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex);
		return storeIndex;
	}
 
	private static String quickSelect(String[] array, int n) {
		int left = 0;
		int right = array.length - 1;
		Random rand = new Random();
		while (right >= left) {
			int pivotIndex = partition(array, left, right, rand.nextInt(right - left + 1) + left);
			if (pivotIndex == n) {
				return array[pivotIndex];
			} else if (pivotIndex < n) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return null;
	}
	public static void swap(String[] array, int index1, int index2) 
	
	{
		String temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	
	
	/**
	 * 세번째 시도
	 * 
	 * */
	private static int partition(int[] array, int left, int right, int pivot) {
		int pivotVal = array[pivot];
		swap(array, pivot, right);
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (array[i]<pivotVal) {
				swap(array, i, storeIndex);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex);
		return storeIndex;
	}
 
	private static Integer quickSelect(int[] array, int n) {
		int left = 0;
		int right = array.length - 1;
		Random rand = new Random();
		while (right >= left) {
			int pivotIndex = partition(array, left, right, rand.nextInt(right - left + 1) + left);
			if (pivotIndex == n) {
				return array[pivotIndex];
			} else if (pivotIndex < n) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return null;
	}
 
	
	
	/**
	 * 두번째 시도
	 * 
	 * */
	
	public static void quickSortPivotMedian(int[] array, int left, int right) {
		int size = right - left + 1;
		if (size <= 3) {
			manualSort(array, left, right, size);
		} else {
			int median = medianOf3(array, left, right);
			int partition = partitionIt(array, left, right, median);
			quickSortPivotMedian(array, left, partition - 1);
			quickSortPivotMedian(array, partition + 1, right);
		}
	}

	public static int medianOf3(int[] array, int left, int right) {
		int center = (left + right) / 2;
		if (array[left] > array[center])
			swap(array, left, center);
		if (array[left] > array[right])
			swap(array, left, right);
		if (array[center] > array[right])
			swap(array, center, right);

		swap(array, center, right - 1); 
		return array[right - 1];
	}

	public static int partitionIt(int[] array, int left, int right, long pivot) {
		int leftPtr = left; 
		int rightPtr = right - 1; 

		while (true) {
			while (array[++leftPtr] < pivot)
				; 
			while (array[--rightPtr] > pivot)
				; 
			if (leftPtr >= rightPtr) 
				break; 
			else
				swap(array, leftPtr, rightPtr); 
		} 
		swap(array, leftPtr, right - 1);
		return leftPtr;
	}
	
	public static void manualSort(int[] array, int left, int right, int size) {

		if (size <= 1)
			return; 
		if (size == 2) { 
			if (array[left] > array[right])
				swap(array, left, right);
			return;
		} else 
		{ 
			if (array[left] > array[right - 1])
				swap(array, left, right - 1); 
			if (array[left] > array[right])
				swap(array, left, right); 
			if (array[right - 1] > array[right])
				swap(array, right - 1, right); 
		}
	}
	
	public static void swap(int[] array, int index1, int index2) 
	
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	
	/**
	 * 
	 * 첫 번쨰 시도
	 * 
	 * */
	// Pivot 0
	public static void quickSortPivotZero(int[] array, int left, int right) {
		if (left < right) {
			int pivot = array[left];
			int i = left;
			int j = right;

			while (i < j) {
				while (array[j] > pivot)
					j--;
				while (i < j && array[i] <= pivot)
					i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			array[left] = array[i];
			array[i] = pivot;

			quickSortPivotZero(array, left, i - 1);
			quickSortPivotZero(array, i + 1, right);
		}
	}

}
