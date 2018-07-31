

import java.util.*;


public class turtle{


   public static void main(String[] args){
      Scanner in = new Scanner( System.in );
      int a=1, b=1, c=1, d = 1;
      String[] values = in.nextLine().split(" ");
      a = Integer.parseInt(values[0]);
      b = Integer.parseInt(values[1]);
      c = Integer.parseInt(values[2]);
      d = Integer.parseInt(values[3]);
      
      int[] sorted = new int[4];
      sorted[0] = a;
      sorted[1] = b;
      sorted[2] = c;
      sorted[3] = d;
      for(int i=0; i<4;i++){
         for(int j=i+1; j<4; j++){
            if(sorted[j]<sorted[i]){
               int temp = sorted[i];
               sorted[i] = sorted[j];
               sorted[j] = temp;
            }

         }
      }
     
      System.out.println(sorted[0]*sorted[2]); 
   }


}
