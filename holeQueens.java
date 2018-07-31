import java.util.*;
import java.io.*;

public class holeQueens {
   public static int solutionCount;
   
   boolean[] rows = new boolean[n];
   //boolean[] columns = new boolean[n];
   boolean[] upperDiagonal = new boolean[2*n];
   boolean[] lowerDiagonal = new boolean[2*n];
         //upperDiagonal[(x+y)] = true;
         //lowerDiagonal[((n-1)+(x-y))] = true;
   public static void backtrackDFS(int n, int row){
      //count each time we get to the end
      //level goes from 0 to n-1
      //this is a process of choosing columns in the solution
      if(level == n){ solutionCount++;}
      for(int i=0; i<n;i++){
         backtrackDFS(n,row++);
      }
      

   }
   
   public static void main(String[] args) {
      Scanner in = new Scanner( System.in );
      int n = in.nextInt();
      int m = in.nextInt();
      in.nextLine();
      
      while((n+m)!=0){
         int[][] board = new int[n][n]; //want this to expire after each case
         int x;
         int y;
         for(int i=0; i<m; i++){
            x = in.nextInt();
            y = in.nextInt();
            in.nextLine();
            board[x][y] = -1;
         }
         //holes are constructed on the board

         //now get answers
         //using the diagonalized boolean arrays we can do
         //while array[i] and then iterate the i
         //first time it should be fine
         //can do iterative solution, choosing for each beginning point in 0, etc
         //just have to count i back down

         n = in.nextInt();
         m = in.nextInt();
         in.nextLine();

      }

   }


}
