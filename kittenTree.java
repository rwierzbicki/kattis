//v00806259 Ramunas Wierzbicki


import java.util.*;

class kittenTree{

   public static void main(String[] args){
      int[] tree = new int[101];
      Scanner in = new Scanner( System.in );
      int kitten = in.nextInt(); in.nextLine();
      int branch;
      int root;
      String[] line;
      while(in.hasNext()){
         line = in.nextLine().split(" ");
         root = Integer.parseInt(line[0]);
         for(int i =1; i<line.length; i++){
            branch = Integer.parseInt(line[i]); 
            tree[branch] = root;
         }
      }
      String path = "";
      path +=kitten;
      //int findRoot = tree[kitten];
      while(kitten != 0){
         //System.out.println(kitten);
         kitten = tree[kitten];
         if(kitten!=0) {path+= " " + kitten;}
      }
      System.out.println(path);
   }

}
