package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DijkstraShortestPath {
	
	public static void printPath(int[] parent, int node) {
		if (parent[node] == -1) {
			System.out.print("\t" + 0 + "\t");
			return;
		}
		printPath(parent, parent[node]);
		System.out.print("\t" + node + "\t");
	}
	
	public static void printShortestPathDist(GraphAM graph) {
		
		int[] nodes = new int[graph.V];
		for (int i = 0; i < graph.V; i++)
			nodes[i] = i;
		int[] dist = new int[graph.V];
		int[] parent = new int[graph.V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		dist[0] = 0;
		List<Integer> unvisited = new LinkedList<Integer>();
		for (int i = 0; i < graph.V; i++)
			unvisited.add(i);
		
		while (!unvisited.isEmpty()) {
			int node = unvisited.remove(0);
			for (int i: nodes) {
				if (graph.mat[node][i] == -1)
					continue;
				int temp = dist[i];
				dist[i] = Math.min(dist[i], dist[node] + graph.mat[node][i]);
				if (dist[i] != temp) parent[i] = node;
			}
		}
		
		for (int i = 0; i < graph.V; i++) {
			System.out.print(i + "\t" + dist[i] + "\t");
			printPath(parent, i);
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		GraphAM graph = new GraphAM(5);
		graph.insertEdge(0, 1, 4);
		graph.insertEdge(0, 2, 8);
		graph.insertEdge(1, 2, 2);
		graph.insertEdge(1, 3, 5);
		graph.insertEdge(2, 3, 5);
		graph.insertEdge(2, 4, 1);
		graph.insertEdge(3, 4, 1);
		
		printShortestPathDist(graph);

	}

}
