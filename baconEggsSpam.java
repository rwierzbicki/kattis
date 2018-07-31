//v00806259 Ramunas Wierzbicki

import java.util.*;
class bagonEggsSpam{


   public static void main(String[] args){
      Scanner in = new Scanner( System.in );
      int n=0;
      String[] line;
      String name;
   
 
      while(in.hasNext()){
         
         HashMap<String , ArrayList<String>> orders = new HashMap<>();
         ArrayList<String> food = new ArrayList<>();
         n = in.nextInt(); in.nextLine();
         
         if(n==0){break;}
         for(int i =0; i<n;i++){
            name = in.next();
            line = in.nextLine().substring(1).split(" "); //substring to get rid of leading space
            //now put things into the hashmap
            for(int k=0; k<line.length;k++){
               if(! orders.containsKey(line[k]) ){
                  //create an arraylist so we can put the mapped pair in
                  ArrayList<String> names = new ArrayList<>();
                  names.add(name);
                  orders.put(line[k], names);
                  food.add(line[k]);
               }
               else{
                  //food.add(line[k]);
                  ArrayList<String> names = orders.get(line[k]);
                  names.add(name);
                  orders.put(line[k], names);
               }
               
            }
         }
         
         //ok just need to put out a sorted list of shit
         //sort the list of food
         Collections.sort(food);
         for(String item: food){
            ArrayList<String> names = orders.get(item);
            Collections.sort(names);


            System.out.print(item);
            for(String person:names){

               System.out.print(" "+ person);
            } 
            
            System.out.println();       
         }
         System.out.println();
         
      }   
   }
}

/*            {
            if (!map.containsKey(ing[i]))
                {
                ArrayList<String> in = new ArrayList<>();
                in.add(name);
                map.put(ing[i] , in);
                ingredients.add(ing[i]);
                }
            else
                {
                ArrayList<String> in = map.get(ing[i]);
                in.add(name);
                map.put(ing[i] , in);
                }
            }
        }

*/
