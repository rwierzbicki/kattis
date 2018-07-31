

import java.util.*;

public class graphBF{

   static class Vertex {
       private ArrayList<Edge> neighborhood;
       private boolean visited;
       
       public Vertex(){
           this.neighborhood = new ArrayList<Edge>();
           this.visited = false;
       }
       public void addNeighbor(Edge edge){
           if(this.neighborhood.contains(edge)){
               return;
           }
           
           this.neighborhood.add(edge);
       }
   }
   static class Edge {
      int start, end; // endpoints
      int weight; // distance
      Edge( int start, int end, int weight ) { this.start = start; this.end = end; this.weight=weight; }
   }


   public static void main(String[] args){
      Scanner in = new Scanner( System.in );
      
      //n m q s
      int n=1, m=1, q=1, s = 1;
      String[] values = in.nextLine().split(" ");
      n = Integer.parseInt(values[0]);
      m = Integer.parseInt(values[1]);
      q = Integer.parseInt(values[2]);
      s = Integer.parseInt(values[3]);

      while( (n+m+q+s)!=0){
         
         Vertex[] vertices = new Vertex[n];
         for(int i =0; i<n;i++){
            vertices[i] = new Vertex();
         }

         int[] shortestPath = new int[n];
         Arrays.fill(shortestPath, Integer.MAX_VALUE);
         shortestPath[s] = 0;


         for(int i=0; i<m;i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int weight =in.nextInt();
            in.nextLine();
            Edge temp = new Edge(start, end, weight);
            vertices[start].addNeighbor(temp);
         }

         //have our graph set up

         boolean change = true;
         while(change){
            change=false;
            count++;
            for(int i = 0; i<n ; i++){

               if(shortestPath[i]!=Integer.MAX_VALUE){

                  for(Edge neighbor: vertices[i].neighborhood){
                     
                     if( (shortestPath[i]+neighbor.weight)<shortestPath[neighbor.end]){
                        shortestPath[neighbor.end] = shortestPath[neighbor.start]+neighbor.weight;
                        change = true;
                     }

                  }
               }

            } 
         }        
         


         //do the queries
         int index;
         for(int i =0; i<q;i++){
            index = in.nextInt();
            if(shortestPath[index] == Integer.MAX_VALUE){ System.out.println("Impossible");}
            else System.out.println(shortestPath[index]);
            in.nextLine();
         }
         


         values = in.nextLine().split(" ");
         n = Integer.parseInt(values[0]);
         m = Integer.parseInt(values[1]);
         q = Integer.parseInt(values[2]);
         s = Integer.parseInt(values[3]);
      }
   }

}

