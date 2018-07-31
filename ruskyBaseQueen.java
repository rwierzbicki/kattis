import java.util.*;
class ruskyBaseQueen {

   static int[] x = new int[128];          // solution, a bad variable name for it though
   static boolean[] a = new boolean[128];  // row free?
   static boolean[] b = new boolean[128];  // / diag free?
   static boolean[] c = new boolean[128];  // \ diag free?
   static int count = 0;
   static int N;
   boolean[][] holes = new boolean[128][128];

   static void gen ( int col,boolean holes[][] ) {
      for ( int row = 0; row < N; ++row ) {
         if (a[row] && b[row+col] && c[row-col+N] && !holes[row][col]) { 
            x[col] = row;
            a[row] = b[row+col] = c[row-col+N] = false;
            if (col < N-1) gen( col+1 ,holes); else count++; 


            a[row] = b[row+col] = c[row-col+N] = true;
         }
      }      
   }

   public static void main(String[] args) {
      Scanner in = new Scanner( System.in );
      N = in.nextInt();
      int m = in.nextInt();
      in.nextLine();
      
      while((N+m)!=0){
         boolean[][] holes = new boolean[128][128];
         int x;
         int y;
         for(int i=0; i<m; i++){
            x = in.nextInt();
            y = in.nextInt();
            in.nextLine();
            holes[x][y] = true;
         }
         for (int i=0; i<2*N+2; ++i) a[i] = b[i] = c[i] = true;
         //holes are constructed on the board
         gen(0, holes);

         System.out.println(ruskyBaseQueen.count);
         
         N = in.nextInt();
         m = in.nextInt();
         ruskyBaseQueen.count=0;
         in.nextLine();

      }

   }
}
