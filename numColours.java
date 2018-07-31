import java.util.*;

class numColours{

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
         this.notAllowedColours =new boolean[n]; //double negative...
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

   static void cleanData(Vertex[] vertices){
      for(int i=0; i <vertices.length;i++){
         vertices[i].visited = false;
         vertices[i].colour =0 ;
         vertices[i].notAllowedColours =new boolean[vertices.length];
      }

   }
   static void traverse(Vertex node, Vertex[] vertices){
         node.visited = true;
         //set to visited and find minimum colour which works
         for(int i=0;i<node.notAllowedColours.length;i++){
            if(!node.notAllowedColours[i]){
               node.colour=i;
               if(i>max){max = i;}
               i=node.notAllowedColours.length*2; //skip the rest of the loop
            }
         }
         //all neighbors aren't allowed to have the node's current colour
         for(Edge neighbor: node.neighborhood){
            vertices[neighbor.end].notAllowedColours[node.colour] = true;             
         }
         //run on each node if not visited          
         for(Edge neighbor: node.neighborhood){
            if(!vertices[neighbor.end].visited){
               traverse(vertices[neighbor.end], vertices);
            }
         }      

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
      int currentMax = Integer.MAX_VALUE;
      for(int i =0; i<n;i++){
         traverse(vertices[i], vertices);
         cleanData(vertices);
         if(numColours.max+1<currentMax){currentMax=numColours.max+1;}
         numColours.max = 0;
      }
      System.out.println(currentMax);
   }
      


      
   }






