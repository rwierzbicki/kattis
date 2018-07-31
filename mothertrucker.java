import java.util.*;




class mothertrucker{
   //could've passed my result array instead of using class variables. refactor "later"
   public static int finalweight = 999999;
   public static int finalstuff = -1;
   public static int[][] mostval;
   final public static int NOEDGE = 1000000000;


   private static int[] dfs(int[][] adjmatrix, int[] requests, int i, int end, int weight, int stuff){
      int[] result = {0,0};
      if(i==end){
         //int print = stuff+requests[end];
         //System.out.println("found a path weighing "+weight+ " and stuff " +print);
         if(weight<mothertrucker.finalweight){
            mothertrucker.finalweight = weight;
            mothertrucker.finalstuff = stuff+requests[end];
         }
         if(weight == mothertrucker.finalweight && stuff>mothertrucker.finalstuff){         
            mothertrucker.finalstuff = stuff+requests[end];
         }
         //return result;

      }
      //cannot be speculative with execution and do j=i: could not find 1>3>2>end, for example
      //but it's mostly 0s so it's fine
      //each nonzero value represents the cost of going from the current node to that node
      for(int j =0; j<adjmatrix[0].length;j++){
         if(adjmatrix[i][j] != 0){
            weight = weight+adjmatrix[i][j];
            stuff += requests[i];
            dfs(adjmatrix,requests,j,end, weight, stuff);
         }
      }

      result[0] = mothertrucker.finalweight;
      result[1] = mothertrucker.finalstuff;
      return result;
   }

   public static void main(String[] args){

      Scanner in = new Scanner( System.in );
      int numNodes = in.nextInt(); in.nextLine();
      int[][] roads = new int[numNodes][numNodes]; //adj matrix with weights
      //System.out.println("initial value of roads " + roads[0][2]);

      String[] requests = in.nextLine().split(" ");
      int[] requestInts = new int[requests.length];
      for(int i = 0; i<requests.length; i++){
         requestInts[i] = Integer.parseInt(requests[i]);
         //System.out.println(requests[i]);

      }
      int numRoads = in.nextInt(); in.nextLine();

		mostval = new int[numNodes][numNodes];
		for (int i=0; i<numNodes; i++) {
			Arrays.fill(roads[i], NOEDGE);
			roads[i][i] = 0;
		}
		
		// Store what you can pick up.
		for (int i=0; i<numNodes; i++) {
			for (int j=0; j<numNodes; j++) {
				if (i != j)
					mostval[i][j] = requestInts[i] + requestInts[j];
				else
					mostval[i][j] = requestInts[i];
			}
		}

      for(int i =0; i<numRoads; i++){
         int pointA = in.nextInt()-1; //-1 adjust for matrix address
         int pointB = in.nextInt()-1;
         int weight = in.nextInt();
         in.nextLine();
         roads[pointA][pointB] = weight; //asymmetric adjacency matrix with diagonal 0s
         roads[pointB][pointA] = weight;
         //System.out.println(pointA + " " + pointB + " " +weight);
      }

		for (int k=0; k<numNodes; k++) {
			for (int i=0; i<numNodes; i++) {
				for (int j=0; j<numNodes; j++) {
					
					// Unique best distance.
					if (roads[i][k] + roads[k][j] < roads[i][j]) {
						roads[i][j] = roads[i][k] + roads[k][j];
						mostval[i][j] = mostval[i][k] + mostval[k][j] - requestInts[k];
					}
					
					// Same best distance, see if we can pick up more stuff this way.
					else if (roads[i][k] + roads[k][j] == roads[i][j] 
                        &&  mostval[i][k] + mostval[k][j] - requestInts[k] > mostval[i][j]) {
						mostval[i][j] = mostval[i][k] + mostval[k][j] - requestInts[k];
					}
				}
			}
		}
      //do the algorithm  
      //               adjac, reqs,        start,  end,        weight,     stuff at start location
      //int[] cost = dfs(roads, requestInts,   0,    numNodes-1, 0,          requestInts[0]);
      //if(mothertrucker.finalstuff != -1 && mothertrucker.finalweight !=999999){System.out.println(cost[0]+" "+cost[1]);}
      //if(mothertrucker.finalstuff ==-1){System.out.println("impossible");}
      		if (roads[0][numNodes-1] == NOEDGE)
			System.out.println("impossible");
		else
			System.out.println(roads[0][numNodes-1]+" "+mostval[0][numNodes-1]);
   }
}

