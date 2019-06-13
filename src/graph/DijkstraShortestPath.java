package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DijkstraShortestPath {
	
	public static void printShortestPathDist(GraphAM graph) {
		
		int[] dist = new int[graph.V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		List<Integer> unvisited = new LinkedList<Integer>();
		for (int i = 0; i < graph.V; i++)
			unvisited.add(i);
		
		while (!unvisited.isEmpty()) {
			int node = unvisited.remove(0);
			for (Integer i: unvisited) {
				if (graph.mat[node][i] == -1)
					continue;
				dist[i] = Math.min(dist[i], dist[node] + graph.mat[node][i]);
			}
		}
		
		for (int i = 0; i < graph.V; i++) {
			System.out.println(i + "\t" + dist[i]);
		}
		
	}

	public static void main(String[] args) {
		
		GraphAM graph = new GraphAM(5);
		graph.insertEdge(0, 1, 4);
		graph.insertEdge(0, 2, 8);
		graph.insertEdge(1, 2, 2);
		graph.insertEdge(1, 3, 5);
		graph.insertEdge(2, 3, 5);
		graph.insertEdge(2, 4, 9);
		graph.insertEdge(3, 4, 4);
		
		printShortestPathDist(graph);

	}

}
