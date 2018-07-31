// Kattis problem "Dice Betting" 3.8
// Type: Counting, probability, DP table.
// Comment: On 226 HW#3, non-recursive version.

import java.util.*;

class DiceBetting {

   static double[][] C = new double[10001][501];
   
   static void initC( int N, double S, int K ) {
      C[0][K] = 1.0;
      for (int r=1; r<N; ++r ) {
         C[r][K] = 1.0;
         for (int d=0; d<K; ++d ) {
            double p = ((double)d)/S;
            C[r][d] = p * C[r-1][d] + (1.0-p) * C[r-1][d+1];
         }
      }
   }

   public static void main ( String[] args ) {
      Scanner in = new Scanner( System.in );
      int N = in.nextInt(), S = in.nextInt(), K = in.nextInt();
      initC( N, (double)S, K ); 
      System.out.println( C[N-1][1] ); // = C[N][0]
   }
}


/*

The input consists of a single line with three integers n, s, and k (1≤n≤10000,1≤k≤s≤500). 
n is the number of throws, 
k the number of different numbers that are needed to win and 
s is the number of sides the die has.

Output
Output one line with the probability that a player throws at least k different numbers 
within n throws with an s-sided die. Your answer should be within absolute or relative error at most 10−7.



*/
