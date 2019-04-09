package sorting;

import java.util.Scanner;

public class QuickSort {
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int i = start - 1;
		
		for (int j = start; j < end; j++) {
			
			if (arr[j] <= arr[pivot]) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			
		}
		
		int temp = arr[i + 1];
		arr[i + 1] = arr[pivot];
		arr[pivot] = temp;
		
		pivot = i + 1;
		
		return pivot;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int piv = partition(arr, start, end);
			quickSort(arr, start, piv-1);
			quickSort(arr, piv + 1, end);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[50];
		int size = scan.nextInt();
		
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
 		}
		
		quickSort(arr, 0, size-1);
		
//		System.out.println(partition(arr, 0, size));
		System.out.println("---");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		
		scan.close();
		
	}
	
}
