package graph;

import java.util.Scanner;

public class BasicImpl {
	
	public static void depthFirstSearchTraversal_Helper(int[][] edges, int[] visited, int startNode) {
		visited[startNode] = 1;
		System.out.print(startNode + "\t");
		for (int i = 0; i < edges[startNode].length; i++) {
			if (edges[startNode][i] == 1 && visited[i] != 1) {
				depthFirstSearchTraversal_Helper(edges, visited, i);
			}
		}
	}
	
	public static void depthFirstSearchTraversal(int[][] edges) {
		int[] visited = new int[edges.length];
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] != 1) {
				depthFirstSearchTraversal_Helper(edges, visited, i);
			}
		}
	}

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
//		printMatrix(edges);
		depthFirstSearchTraversal(edges);
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
