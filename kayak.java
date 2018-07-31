

import java.util.*;


public class kayak{


   public static void main(String[] args){
      Scanner in = new Scanner( System.in );
      int n,s,r;
      String[] values = in.nextLine().split(" ");
      n = Integer.parseInt(values[0]);
      s = Integer.parseInt(values[1]);
      r = Integer.parseInt(values[2]);
      int[] requests = new int[n];
      int[] extras = new int[n];
      values = in.nextLine().split(" ");
      for(int i =0; i<values.length;i++){
         requests[Integer.parseInt(values[i])-1]++;
      }
      values = in.nextLine().split(" ");
      //System.out.println("values length is "+values.length);
      for(int i =0; i<values.length;i++){
         
         extras[Integer.parseInt(values[i])-1]++;
      }
      for(int i =0; i<n;i++){
         if(requests[i]>0){
            if(i!=0){
               if(extras[i-1]>0){
                  requests[i]--;
                  extras[i-1]--;
               }
            }  
            if(i<n-1&&requests[i]>0){
               if(extras[i+1]>0){
                  extras[i+1]--;
                  requests[i]--;
               }

            }

         }

      }
      int minimum=0;
      for(int i=0;i<n;i++){
         minimum+=requests[i]; 
      }

      System.out.println(minimum);

      
      
      
   }


}
