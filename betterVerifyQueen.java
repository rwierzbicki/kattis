import java.util.*;

public class betterVerifyQueen {


    public static void main(String[] args) {
      Scanner in = new Scanner( System.in );
      int n = in.nextInt();
      in.nextLine();
      int x;
      int y;
      boolean correct = true;
      boolean[] rows = new boolean[n];
      boolean[] columns = new boolean[n];
      boolean[] upperDiagonal = new boolean[2*n];
      boolean[] lowerDiagonal = new boolean[2*n];
      // yep it prints false System.out.println(upperDiagonal[0]);
      for(int i =0; i<n;i++){
         x = in.nextInt();
         y = in.nextInt();
         in.nextLine();
         if(rows[x]||columns[y] || upperDiagonal[(x+y)] || lowerDiagonal[((n-1)+(x-y))]){correct = false; i=n;}
         rows[x] = true;
         columns[y] = true;
         //how to do diagonals????
         //x-1,y-1
         //upper diagonal is x+y
         upperDiagonal[(x+y)] = true;
         //lower diagonal is abs(x-y)
         lowerDiagonal[((n-1)+(x-y))] = true;
         
      }
      if(correct){System.out.println("CORRECT");}
      else{System.out.println("INCORRECT");}
    }

}




















