package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphFuncs {
	
	private static List<Integer> getConnectedComponentsDFSUtil(Graph g, int node, boolean[] visited, List<Integer> list) {
		
		visited[node] = true;
		list.add(node);
		for (Integer n: g.adj[node]) {
			if (visited[n] == false)
				getConnectedComponentsDFSUtil(g, n, visited, list);
		}
		return list;
	}
	
	public static List<List<Integer>> getConnectedComponents(Graph g) {
		if (g == null)
			return null;
		
		boolean[] visited = new boolean[g.numNodes()];
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < g.numNodes(); i++) {
			if (visited[i] == false) {
				res.add(getConnectedComponentsDFSUtil(g, i, visited, new ArrayList<Integer>()));
			}
		}
		return res;
		
	}
	
	private static void getPathUtil(Graph g, int curr, int target, List<Integer> path, boolean[] visited) {
		
		visited[curr] = true;
		
		if (curr == target) {
			for (Integer ip: path)
				System.out.print(ip + "\t");
			visited[curr] = false;
			System.out.println();
			return;
		}
		
		for (Integer i: g.adj[curr]) {
			if (visited[i] == false) {
				path.add(i);
				getPathUtil(g, i, target, path, visited);
				path.remove(i);
			}
		}
		
		
	}
	
	public static void getPath(Graph g, int s, int e) {
		
		if (s == e || (s >= g.numNodes() || e >= g.numNodes()))
			return;
		
		boolean visited[] = new boolean[g.numNodes()];
		List<Integer> path = new ArrayList<Integer>();
		path.add(s);
		getPathUtil(g, s, e, path, visited);
		
	}

	private static void BFSUtil(Graph g, int node, boolean[] visited) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			int v = queue.remove();
			System.out.print(v + "\t");
			LinkedList<Integer> connections = g.adj[v];
			for (Integer i : connections) {
				if (visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

	public static void BFS(Graph g) {

		boolean visited[] = new boolean[g.numNodes()];

		for (int i = 0; i < g.numNodes(); i++) {
			if (visited[i] == false) {
				BFSUtil(g, i, visited);
			}
		}

	}

	private static void DFSUtil(Graph g, int node, boolean visited[]) {
		visited[node] = true;
		System.out.print(node + "\t");
		LinkedList<Integer> connections = g.adj[node];
		for (Integer i : connections) {
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

		List<List<Integer>> result = getConnectedComponents(g);
		
		for (List<Integer> list: result) {
			for (Integer i: list) {
				System.out.print(i + "\t");
			}
			System.out.println("\n");
		}

	}

}
