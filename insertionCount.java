//v00806259
import java.util.*;
import java.math.BigInteger;

class insertionCount{

   static class Node{
      int value;
      int subnodes=0;
      BigInteger permutations;
      Node L_child;
      Node R_child;
      Node(int num){this.value=num;}
      public void addNode(Node root, int child){
         if(child >= root.value){
            if(root.R_child ==null){
               root.R_child = new Node(child);
            }
            else{addNode(root.R_child, child);}
         }
         if(child<root.value){
            if(root.L_child==null){
               root.L_child= new Node(child);
            }
            else{addNode(root.L_child, child);}
         }
      } 
   }
	static BigInteger multiply(int min, int max) {
		BigInteger x = BigInteger.ONE;
		for (int i = min; ++i <= max; ) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}
	static BigInteger comb(int n, int k) {
		if (k > n/2) k = n-k;
		return multiply(n-k, n).divide(multiply(0, k));
	}
   static void compute(Node root){
      BigInteger L_permutation;
      BigInteger R_permutation;
      int L_counts=0;
      int R_counts=0;
      Node left = root.L_child;
      Node right = root.R_child;
      if(left==null){
         L_permutation =BigInteger.ONE;
      }
      else {
			compute(left);
			L_permutation = left.permutations;
			L_counts = left.subnodes;
		}
      if(right==null){
         R_permutation= BigInteger.ONE;
      } 
      else {
			compute(right);
			R_permutation = right.permutations;
			R_counts = right.subnodes;
		} 
		root.subnodes = L_counts + R_counts + 1;
		root.permutations = L_permutation.multiply(R_permutation).multiply(comb(L_counts+R_counts, L_counts));
   }
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      int n=-1;
      String[] line;
      n = in.nextInt(); 
      
      while(n!=0){
         in.nextLine();
         line = in.nextLine().split(" ");
         
         Node root = new Node(Integer.parseInt(line[0]));
         for(int i=1;i<line.length;i++){
            root.addNode(root,Integer.parseInt(line[i]));
         }
         compute(root);
         System.out.println(root.permutations);
         n=in.nextInt();
      }
   }


}
