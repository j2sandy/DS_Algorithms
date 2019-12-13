package io.nishandi.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandProblem {
	
	static class MazeCell{
		int row, col;
		int dist;
	}

	public static void main(String[] args) {
		int maze[][]= {{1,0,0,1},
		               {1,0,1,1},
		               {1,1,0,0},
		               {0,1,0,1}};
		
		int n=maze.length;
		int min=getMinDistance(maze,n);
		System.out.println(min);
		

	}
	
	
	
	public static boolean isSafe(int row,int col,int maze[][]) {
		
		if((row>=0 && row<maze.length) && (col>=0 && col<maze.length) && maze[row][col]!=0)
			return true;
		else
			return false;
		
	}
	
	public  static int getMinDistance(int maze[][],int n) {
		
		boolean visited[][]=new boolean[n][n];
		Arrays.fill(visited[0], false);
		Arrays.fill(visited[1], false);
		Arrays.fill(visited[2], false);
		Arrays.fill(visited[3], false);
		
		Queue<IslandProblem.MazeCell> queue=new LinkedList<IslandProblem.MazeCell>();
		
		MazeCell curr=new MazeCell();
		curr.row=0;
		curr.col=0;
		curr.dist=0;
		visited[0][0]=true;
		
		queue.add(curr);
		while(!queue.isEmpty()) {
			
			curr=queue.remove();
			if(curr.row==n-1 && curr.col==n-1)
				break;
			
			//down
			if(isSafe(curr.row+1, curr.col, maze) && !visited[curr.row+1][curr.col])
			{
				MazeCell cell=new MazeCell();
				cell.row=curr.row+1;
				cell.col=curr.col;
				cell.dist=curr.dist+1;
				queue.add(cell);
				visited[cell.row][cell.col]=true;
			}
			
			//left
			if(isSafe(curr.row, curr.col-1, maze) && !visited[curr.row][curr.col-1])
			{
				MazeCell cell=new MazeCell();
				cell.row=curr.row;
				cell.col=curr.col-1;
				cell.dist=curr.dist+1;
				queue.add(cell);
				visited[cell.row][cell.col]=true;
			}
			
			//up
			if(isSafe(curr.row-1, curr.col, maze) && !visited[curr.row-1][curr.col])
			{
				MazeCell cell=new MazeCell();
				cell.row=curr.row-1;
				cell.col=curr.col;
				cell.dist=curr.dist+1;
				queue.add(cell);
				visited[cell.row][cell.col]=true;
			}
			
			//right
			if(isSafe(curr.row, curr.col+1, maze) && !visited[curr.row][curr.col+1])
			{
				MazeCell cell=new MazeCell();
				cell.row=curr.row;
				cell.col=curr.col+1;
				cell.dist=curr.dist+1;
				queue.add(cell);
				visited[cell.row][cell.col]=true;
			}
			
			
		}
		
		if(curr.row==n-1 && curr.col==n-1)
		return curr.dist;
		
		else
			return Integer.MAX_VALUE;
	}

}
