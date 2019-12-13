package io.nishandi.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

	public static void main(String[] args) {
		int N = 30; 
        int moves[] = new int[N]; 
        for (int i = 0; i < N; i++) 
            moves[i] = -1; 
  
        // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6; 
        int n=getMinDiceThrows(moves, 30);
System.out.println(n);
	}
	
	static class QEntry{
		int v;
		int dist;
	}
	
	static int getMinDiceThrows(int move[],int n) {
		int visited[]=new int[n];
		
		Queue<SnakeLadder.QEntry> queue=new LinkedList<SnakeLadder.QEntry>();
		QEntry q=new QEntry();
		q.v=0;
		q.dist=0;
		visited[0]=1;
		queue.add(q);
		while(!queue.isEmpty()) {
			q=queue.remove();
			
			int v=q.v;
			if(v==n-1)
				break;
			for(int i=v+1;i<=v+6 && i<n;i++) {
				if(visited[i]==0) {
					QEntry q_new=new QEntry();
					q_new.dist=q.dist+1;
					visited[i]=1;
					
					if(move[i]==-1)
						q_new.v=i;
					else
						q_new.v=move[i];
					
					queue.add(q_new);
					
				}
			}
		}
		
		return q.dist;
		
	}
	
}
