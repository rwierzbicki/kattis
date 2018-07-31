import java.util.*;

class iterativeColours{

   static int max;
   static class Vertex {
      private ArrayList<Edge> neighborhood;
      private boolean visited;
      private int colour;
      private boolean[] notAllowedColours;
      
       
      public Vertex(int n){
         this.neighborhood = new ArrayList<Edge>();
         this.visited = false;
         this.colour = 0;
         this.notAllowedColours =new boolean[n];
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
      Edge( int start, int end ) { this.start = start; this.end = end;}
   }
 
   
   public static void main(String[] args) {
      Scanner in = new Scanner( System.in );

      int n = in.nextInt();
      in.nextLine();
      Vertex[] vertices = new Vertex[n];
      for(int i =0; i<n;i++){
         vertices[i] = new Vertex(n);
      }
      int count = 0;
      int[] colours = new int[n];
      String[] input;
      for(int i =0; i<n;i++){
         input = in.nextLine().split(" ");

         for(int j=0; j<input.length;j++){
            int index = Integer.parseInt(input[j]);
            Edge temp = new Edge(i, index);
            vertices[i].addNeighbor(temp);
         }
       }
      for(int i=0;i<vertices.length;i++){
         for(int j=0;j<vertices.length;j++){

            if(!vertices[i].notAllowedColours[j]){
               vertices[i].colour=j;
               if(j>iterativeColours.max){max=j;}
               j=vertices.length+1;
            }
         }
         for(Edge neighbor: vertices[i].neighborhood){
            vertices[neighbor.end].notAllowedColours[vertices[i].colour]=true;
         }
      }  


      System.out.println(iterativeColours.max+1);
   }
      


      
}






