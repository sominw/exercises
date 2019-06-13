package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimsMST {
	
	public static GraphAM primsMST(GraphAM g) {
		GraphAM res = new GraphAM(g.V);
		ArrayList<Integer> unvisited = new ArrayList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		int[] weight = new int[g.V];
		int[] parent = new int[g.V];
		
		for (int i = 0; i < g.V; i++) {
			unvisited.add(i);
		}
		
		Arrays.fill(weight, Integer.MAX_VALUE);
		weight[0] = 0;
		Arrays.fill(parent, -1);
		while (!unvisited.isEmpty()) {
			int node = unvisited.remove(0);
			visited.add(node);
			for (int j = 0; j < g.V; j++) {
				if (j == node || g.mat[node][j] == -1 || visited.contains(j))
					continue;
				int temp = weight[j];
				weight[j] = Math.min(weight[j], g.mat[node][j]);
				if (temp != weight[j])
					parent[j] = node;
			}
		}
		
		for (int i = 1; i < g.V; i++) {
//			System.out.println(i + "\t" + parent[i] + "\t" + weight[i]);
			res.insertEdge(parent[i], i, weight[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		GraphAM g = new GraphAM(5);
		g.insertEdge(0, 1, 4);
		g.insertEdge(0, 2, 8);
		g.insertEdge(1, 2, 2);
		g.insertEdge(1, 3, 6);
		g.insertEdge(2, 3, 3);
		g.insertEdge(2, 4, 9);
		g.insertEdge(3, 4, 5);
//		System.out.println(g.toString());
		GraphAM res = primsMST(g);
		res.toString();
	}
}

class GraphAM {
	
	int V;
	int[][] mat;
	
	public GraphAM(int v) {
		
		this.V = v;
		this.mat = new int[v][v];
		for (int[] row: this.mat) {
			Arrays.fill(row, -1);
		}
	}
	
	public void insertEdge(int src, int dest, int weight) {
		if (src < 0 || dest < 0 || src >= this.V || dest >= this.V) {
			System.out.println("Error inserting edge!");
			return;
		}
		this.mat[src][dest] = weight;
//		this.mat[dest][src] = weight;
	}
	
	public void removeEdge(int src, int dest) {
		if (src < 0 || dest < 0 || src >= this.V || dest >= this.V || this.mat[src][dest] == -1) {
			System.out.println("Error removing edge!");
			return;
		}
		this.mat[src][dest] = -1;
		this.mat[dest][src] = -1;
	}
	
	@Override
	public String toString() {
		System.out.println("\n");
		System.out.print("\t");
		for (int i = 0; i < this.mat.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n");
		for (int i = 0; i < this.mat.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < this.mat.length; j++) {
				System.out.print(this.mat[i][j] + "\t");
			}
			System.out.println();
		}
		return "";
	}
	
}
