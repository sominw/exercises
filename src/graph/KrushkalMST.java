package graph;

import java.util.ArrayList;
import java.util.Collections;

public class KrushkalMST {
	
	public static GraphE krushkalMST(GraphE graph) {

		GraphE res = new GraphE(graph.V, graph.V - 1);
		Collections.sort(graph.edges);
		
		int eNum = 0;
		for (GraphE.Edge e: graph.edges) {
			if (eNum == res.E)
				break;
			GraphE.Edge tempE = res.insertEdge(e.src, e.dest, e.weight);
			if (res.containsCycle())
				res.removeEdge(tempE);
			else
				eNum++;
			
		}
		return res;	
	}
	
	public static void main(String[] args) {
		GraphE graph = new GraphE(4, 5);
		graph.insertEdge(0, 1, 2);
		graph.insertEdge(1, 2, 5);
		graph.insertEdge(2, 3, 4);
		graph.insertEdge(3, 0, 3);
		graph.insertEdge(0, 2, 0);
		
		System.out.println("Current Graph (src-dest-weight)\n");

		for (GraphE.Edge e: graph.edges) {
			System.out.println(e.src + "\t" + e.dest + "\t" + e.weight);
		}
		
		GraphE res = krushkalMST(graph);
		
		System.out.println("\n\nMST using Krushkal's Algorithm (src-dest-weight)\n");
		
		for (GraphE.Edge e: res.edges) {
			System.out.println(e.src + "\t" + e.dest + "\t" + e.weight);
		}
	}
	
}

class GraphE {

	int V, E;
	ArrayList<Edge> edges;

	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		
		@Override
		public int compareTo(Edge o) {
			if (this.weight > o.weight)
				return 1;
			else if (this.weight < o.weight)
				return -1;
			return 0;
		}
	}

	public GraphE(int V, int E) {
		this.V = V;
		this.E = E;
		edges = new ArrayList<Edge>();
	}
	
	public Edge insertEdge(int src, int dest, int weight) {
		if (src < 0 || src >= this.V || dest < 0 || dest >= this.V || edges.size() >= this.E) {
			System.out.println("Unable to insert edge");
			return null;
		}
		Edge e = new Edge();
		e.src = src;
		e.dest = dest;
		e.weight = weight;
		edges.add(e);
		return e;
	}
	
	public boolean removeEdge(Edge e) {
		boolean flag = this.edges.remove(e);
		return flag;
	}
	
	int find(int[] parent, int node) {
		if (parent[node] == -1)
			return node;
		return find(parent, parent[node]);
	}

	void setParent(int[] parent, int src_p, int dest_p) {
		int p = find(parent, src_p);
		int t = find(parent, dest_p);
		parent[p] = t;
	}
	
	boolean containsCycle() {
		
		int[] parent = new int[this.V];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		
		for (Edge e: this.edges) {
			
			int src_p = find(parent, e.src);
			int dest_p = find(parent, e.dest);
			
			if (src_p == dest_p)
				return true;
			
			setParent(parent, src_p, dest_p);
			
		}
		
		return false;
	}


}