import java.util.*;




class mothertrucker2{

   public static class Node{
      int items;
      int rootDistance;
      int sumItems;
      int[] childDistance;
      int degree; //keep track of degree, add a child at that index 
      Node[] children;
      private Node(int requests, int numNodes){
         this.items = requests;
         this.rootDistance = 999999;
         this.childDistance = new int[numNodes];
         this.sumItems=0;
         
         this.degree = 0;
         //parentDistance[degree] = b;
         this.children = new Node[numNodes];
      }
      private void addChild(Node child, int distance){
         children[degree] = child;
         childDistance[degree] = distance;
         degree+=1;
      }


   }
   public static void findPaths(Node root, int currentLength, int currentItems){
      currentItems+=root.items;
      for(int a=0; a <root.degree; a++){
         if( (currentLength+root.childDistance[a])<root.children[a].rootDistance){
            root.children[a].rootDistance= currentLength+root.childDistance[a];
         }

         if( currentItems>root.sumItems){
            root.sumItems = currentItems;
         }
         
         
         findPaths(root.children[a],(currentLength+root.childDistance[a]), (currentItems));
         System.out.println(root.sumItems);
         
      }

   }


   public static void main(String[] args){

      Scanner in = new Scanner( System.in );
      int numNodes = in.nextInt(); in.nextLine();

      String[] requests = in.nextLine().split(" ");
      int[] requestInts = new int[requests.length];
      for(int i = 0; i<requests.length; i++){
         requestInts[i] = Integer.parseInt(requests[i]);
         //System.out.println(requests[i]);

      }
      int numRoads = in.nextInt(); in.nextLine();
      Node[] points = new Node[numNodes];

      Node root = new Node( requestInts[0] , numNodes);
      points[0] = root;
      for(int i =0; i<numRoads; i++){
         int pointA = in.nextInt()-1; //-1 adjust for matrix address
         int pointB = in.nextInt()-1;
         int distance = in.nextInt();
         in.nextLine();
         if(points[pointB]==null){
            //create pointB for each line we read
            points[pointB] = new Node(requestInts[pointB],numNodes);
         }
         
         if(points[pointA]==null){
            points[pointA] = new Node(requestInts[pointA],numNodes);
         }
         points[pointA].addChild(points[pointB], distance);
         
         
      
      } 
      int[] distanceFromStart = new int[numNodes];   
      //System.out.println("number of points is " + numNodes + " and the array is length " + requestInts.length);  
      findPaths(root,0,0);
      //System.out.println(points[4].degree + " f u c k " );
      System.out.println(points[numNodes-1].rootDistance+ " " + points[numNodes-1].sumItems);
      //do the algorithm  
      //               adjac, reqs,        start,  end,        weight,     stuff at start location

   }
}
