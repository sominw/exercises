package graph;

public class CycleDetectionUnionFind {
	public static void main(String[] args) {
		GraphEdgeList graph = new GraphEdgeList(5, 4);
		graph.insertEdge(0, 0, 1);
		graph.insertEdge(1, 1, 2);
		graph.insertEdge(2, 2, 3);
		graph.insertEdge(3, 1, 4);
		System.out.println(graph.containsCycle());
	}
}

class GraphEdgeList {

	int V, E;
	Edge edge[];

	class Edge {
		int src, dest;
	}

	public GraphEdgeList(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[e];
		for (int i = 0; i < this.E; i++) {
			edge[i] = new Edge();
		}
	}

	public void insertEdge(int edgeNo, int src, int dest) {
		if (src >= this.V || dest >= this.V || src < 0 || dest < 0 || edgeNo >= this.E || edgeNo < 0)
			return;
		edge[edgeNo].src = src;
		edge[edgeNo].dest = dest;
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
		
		for (int i = 0; i < this.E; i++) {
			
			int src_p = find(parent, this.edge[i].src);
			int dest_p = find(parent, this.edge[i].dest);
			
			if (src_p == dest_p)
				return true;
			
			setParent(parent, src_p, dest_p);
			
		}
		
		return false;
	}

}
