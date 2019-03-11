package graph;

import java.util.Scanner;

public class BasicImpl {
	
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num_edges = scan.nextInt();
		int edges[][] = new int[n][n];

		for (int i = 0; i < num_edges; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			edges[s][e] = 1;
			edges[e][s] = 1;
		}
		printMatrix(edges);
		scan.close();
	}

	static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
