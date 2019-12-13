package io.nishandi.ds.graph;

public class GraphImplUsingAdjacencyMatrix {
	
	private int V;
	private int[][] adjacencyMatrix;
	
	public GraphImplUsingAdjacencyMatrix(int v) {
		V = v;
		this.adjacencyMatrix = new int[v][v];
	}

	public static void main(String[] args) {
		GraphImplUsingAdjacencyMatrix graph=new GraphImplUsingAdjacencyMatrix(5);
		graph.addEdge(0, 1);
		graph.addEdge(0,4);
		graph.addEdge(1, 2);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
		
		
	}
	
	public void printGraph() {
		for(int i=0;i<this.adjacencyMatrix.length;i++)
		{
			for(int j=0;j<this.adjacencyMatrix.length;j++) {
				System.out.print(this.adjacencyMatrix[i][j]);
			}
			System.out.println();
		}
		
	}

	public void addEdge(int source,int dest) {
		this.adjacencyMatrix[source][dest]=1;
		this.adjacencyMatrix[dest][source]=1;
	}

}
