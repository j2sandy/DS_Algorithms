package io.nishandi.algo.backtracking;

public class NQueen {
	final int N=4;
	
	public static void main(String[] args) {
		NQueen nqueen=new NQueen();
		nqueen.solveNQueensUtil();

		
	}
	
	public boolean isSafe(int[][] board,int row,int col) {
		int i,j;
		
		for(i=0;i<col;i++)
			if(board[row][i]==1)
				return false;
		
		for(i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
			if(board[i][j]==1)
				return false;
		
		for(i=row+1,j=col-1;i<N && j>0;i++,j--)
			if(board[i][j]==1)
				return false;
		
		return true;
		
		
	}
	
	public boolean solveNQueens(int [][] board,int col) {
		
		if(col==N)
			return true;
		
		for(int i=0;i<N;i++) {
			if(isSafe(board, i, col)) {
				board[i][col]=1;
				if(solveNQueens(board, col+1)==true)
					return true;
				board[i][col]=0;
			}
		}
		
		return false;
		
	}
	
	public void solveNQueensUtil() {
		int board[][] = { { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 } }; 
		
		if(solveNQueens(board,0))
			{
			  System.out.println("Solution exists");
			  printBaord(board);
			}
		else
			System.out.println("No solution exists");
		
	}
	
	public void printBaord(int board[][]) {
		for(int i=0;i<N;i++)
			{
			    for(int j=0;j<N;j++)
				{
			    	System.out.print(board[i][j]);
			    }
			System.out.println(" ");
			}	
	}

}
