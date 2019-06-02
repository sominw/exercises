package graph;

import java.util.LinkedList;

// Adjacency List
public class Graph {
	
	private int V;
	public LinkedList<Integer> adj[];
	
	public Graph(int v) {
		
		this.V = v;
		this.adj = new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	
	}

	void addEdge(int v, int w) {
		if ((v >= this.V || w >= this.V) || (v == w) ) {
			System.out.println("Invalid Edge");
			return;
		}
//		Creating an undirected graph
		adj[v].add(w);
		adj[w].add(v);
	}
	
	int numNodes() {
		return this.V;
	}
	
	void print() {
		int i = 0;
		for (LinkedList<Integer> list: adj) {
			System.out.print(i + ": ");
			for (Integer node: list) {
				System.out.print(node + "\t");
			}
			System.out.println();
			i++;
		}
	}
	
	
}
