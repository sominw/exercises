package sorting;

import java.util.Scanner;

public class MergeSort {

	public static void merge(int[] arr, int b, int mid, int e) {
		int size_l = (mid - b) + 1;
		int size_r = e - mid;
		
		int[] left = new int[size_l];
		int[] right = new int[size_r];
		
		for (int i = 0; i < size_l; i++) {
			left[i] = arr[b + i];
		}
		for (int i = 0; i < size_r; i++) {
			right[i] = arr[mid + 1 + i];
		}
		
		int i = 0;
		int j = 0;
		int k = b;
		
		while (i < size_l && j < size_r) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < size_l) {
			arr[k++] = left[i];
			i++;
		}
		
		while (j < size_r) {
			arr[k++] = right[j];
			j++;
		}
	}
	
	public static void mergesort(int[] arr, int b, int e) {
		if (e > b) {
			int mid = (e + b)/2;
			mergesort(arr, b, mid);
			mergesort(arr, mid+1, e);
			merge(arr, b, mid, e);
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[50];
		int size = scan.nextInt();
		
		for (int i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		
		mergesort(arr, 0, size - 1);
		
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		scan.close();

	}

}
