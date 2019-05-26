package graph;

public class GraphEdgeList {
	
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
		if (parent[node] == -1) {
			return node;
		}
		return find(parent, parent[node]);
	}
}
