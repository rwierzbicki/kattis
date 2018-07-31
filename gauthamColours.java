import java.util.*;

class gauthamColours{

   static int max;
   static class Vertex {
      private ArrayList<Edge> neighborhood;
      private boolean visited;
      private int colour;
      private boolean[] allowedColours;
      
       
      public Vertex(int n){
         this.neighborhood = new ArrayList<Edge>();
         this.visited = false;
         this.colour = 0;
         this.allowedColours = new boolean[n];
         Arrays.fill(allowedColours, true);
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

   
   static void traverse(Vertex node, Vertex[] vertices){
         node.visited = true;
         //set to visited and find minimum colour which works
         //all neighbors aren't allowed to have the node's current colour 
         for(Edge neighbor: node.neighborhood){
            //for every node that has been visited, we can't use that colour
            if(vertices[neighbor.end].visited){
               node.allowedColours[vertices[neighbor.end].colour]=false;
               if(vertices[neighbor.end].colour>max){max=vertices[neighbor.end].colour;}
            }
            else{ 
               traverse(vertices[neighbor.end],vertices); 
            }              
         }   
         //set the current colour
         for(int i =0; i<vertices.length;i++){
            if(node.allowedColours[i]){
               node.colour = i;
               i=vertices.length+1;
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

      traverse(vertices[0], vertices);
      for(int i=0;i<n;i++){
         if(vertices[0].colour>max){max=vertices[0].colour;}
      }

      System.out.println(gauthamColours.max+1);
   }
      


      
   }






