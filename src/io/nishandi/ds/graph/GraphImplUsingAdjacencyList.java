package io.nishandi.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphImplUsingAdjacencyList {
	
	private int V;
	private LinkedList<Integer>[] adjacencyList;
	
	public GraphImplUsingAdjacencyList(int v) {
		this.V=v;
		adjacencyList=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjacencyList[i]=new LinkedList<Integer>();
			
	}
	
	public static void main(String[] args) {
		GraphImplUsingAdjacencyList graph=new GraphImplUsingAdjacencyList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0,4);
		graph.addEdge(1, 2);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printGraph();
		//graph.printBFS(0);
		boolean[] visited=new boolean[5];
		Arrays.fill(visited, false);
		graph.printDFS(1, visited);
	}
	
	public void addEdge(int source,int dest) {
		
		this.adjacencyList[source].add(dest);
		this.adjacencyList[dest].add(source);
		
	}
	
	public void printGraph() {
		
		for(int i=0;i<this.V;i++) {
			System.out.print("edges from "+i+" :");
			for(int j=0;j<this.adjacencyList[i].size();j++) {
				System.out.print(this.adjacencyList[i].get(j)+" ");
			}
			System.out.println("");
		}
		
	}
	
	//time complexity O(V+E)
	public void printBFS(int source) {
		
		if(source<0 || source>this.V)
			return;
		
		int curr=source;
		boolean visited[]=new boolean[this.V];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(curr);
		visited[curr]=true;
		while(!queue.isEmpty()) {
			 curr=queue.poll();
			 System.out.println(curr);
			 for(int i=0;i<this.adjacencyList[curr].size();i++) {
				 if(visited[this.adjacencyList[curr].get(i)])
					 continue;
				 else
				 {
					 queue.add(this.adjacencyList[curr].get(i));
					 visited[this.adjacencyList[curr].get(i)]=true;
				 }
			 }
			
		}
		
	}
	
	//time complexity O(V+E)
	public void printDFS(int source,boolean visited[]) {
		
		if(visited[source])
			return;
		
		System.out.println(source);
		visited[source]=true;
		
		
		for(int i=0;i<this.adjacencyList[source].size();i++) {
			printDFS(this.adjacencyList[source].get(i), visited);
		}
					
		
	}
	

}
