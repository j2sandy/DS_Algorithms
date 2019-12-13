package io.nishandi.algo.backtracking;

public class SudokuSolver {
	
	public static void main(String[] args) {
		int[][] board = new int[][] 
			    { 
			            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
			            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
			            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
			            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
			            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
			            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
			            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
			            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
			            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
			    }; 
			    int N = board.length; 
			  
			    if (solveSudoku(board, N)) 
			    { 
			        print(board, N); // print solution 
			    }  
			    else
			    { 
			        System.out.println("No solution"); 
			    } 
	}

	public static void print(int[][] board, int n) {
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
		    	System.out.print(board[i][j]);
		    }
		System.out.println(" ");
		}
		
	}

	public static boolean solveSudoku(int[][] board, int n) {
		
		return false;
	}
	
	public static boolean isSafe(int[][] board,int row,int col) {
		return false;
	}

}
