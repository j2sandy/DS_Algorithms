package io.nishandi.algo.backtracking;

public class RatMaze {
	
	static int N;
	public static void main(String[] args) {
		RatMaze rat = new RatMaze(); 
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 
  
        N = maze.length; 
        rat.solveMaze(maze); 
		
	}
	
	public  void solveMaze(int[][] maze) {
		
		System.out.println(solveMazeUtil(maze,0,0));
		
	}
	
	public boolean solveMazeUtil(int maze[][],int row,int col) {
		
		if(row==N-1 && col==N-1)
			return true;
		
		if(isSafe(row+1, col, maze))
		{
			if(solveMazeUtil(maze,row+1,col))
			return true;
		}
			
		
		if(isSafe(row, col+1, maze))
		{
			if(solveMazeUtil(maze,row,col+1))
				return true;
		}
		
		return false;
			
		
	}
	
	public boolean isSafe(int row,int col,int[][] maze) {
		
		return (row>=0 && row<N) && (col>=0 && col<N) && (maze[row][col]!=0);
		
	}

}
