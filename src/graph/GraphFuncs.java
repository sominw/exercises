package graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphFuncs {
	
	private static void BFSUtil(Graph g, int node, boolean[] visited) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			int v = queue.remove();
			if (visited[v] == false) {
				visited[v] = true;
				System.out.print(v +"\t");
			}
			LinkedList<Integer> connections = g.adj[v];
			for (Integer i: connections) {
				if (visited[i] == false)
					queue.add(i);
			}
		}
		
	}
	
	public static void BFS(Graph g) {
		
		boolean visited[] = new boolean[g.numNodes()];
		
		for(int i = 0; i < g.numNodes(); i++) {
			if (visited[i] == false) {
				BFSUtil(g, i, visited);
			}
		}
		
	}
	
	private static void DFSUtil(Graph g, int node, boolean visited[]) {
		visited[node] = true;
		System.out.print(node + "\t");
		LinkedList<Integer> connections = g.adj[node];
		for (Integer i: connections) {
			if (visited[i] == false)
				DFSUtil(g, i, visited);
		}
	}
	
	public static void DFS(Graph g) {
		
		boolean visited[] = new boolean[g.numNodes()];

		for (int i = 0; i < g.numNodes(); i++) {
			if (visited[i] == false)
				DFSUtil(g, i, visited);
		}
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		g.addEdge(0, 3);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(5, 7);
		
		BFS(g);
		
	}

}
