//**num of ways to travel in a n x m grid from top left to bottom right corner**
// we can only go to right or down

import java.util.HashMap;

public class GridTravel {
 
    static HashMap<String, Long> mem = new HashMap<>();
    static long gridTraveler(int r, int c){

        if(r==0 || c==0) return 0; //ie grid is invalid
        if(r==1 && c==1) return 1;

        if(mem.containsKey(toString(r, c))){
            return mem.get(toString(r, c));
        }

        //dont write any preemtive logic like: if(r-1 is within bounds){recursive call for r-1} or if(c-1 is within bounds){recursive call c-1} etc
        // dont check for child keys/cases

        // we are travelling in reverse direction ie from bottom right corner to top left corner but its equivalent
        // u can also travel from top left to bottom right u just have to change the above "if" conditions 
        // and also have to change the below "-" to "+" to go down & right instead of up and left

        long numOfWays = gridTraveler(r-1, c) + gridTraveler(r, c-1); //num of ways to travel to r,c
        mem.put(toString(r, c), numOfWays); //num of ways to travel in r,c grid = num of ways in c,r grid
        mem.put(toString(c, r), numOfWays);

        return numOfWays;
    }

    static String toString(int r, int c){
        return r+","+c;
    }

    public static void main(String[] args) {
        
        System.out.println(gridTraveler(0, 0));
        System.out.println(gridTraveler(1, 1));

        
        System.out.println(gridTraveler(2,3)); //exprected: 3
        System.out.println(gridTraveler(3,2)); //exprected: 3
        System.out.println(gridTraveler(3,3)); //exprected: 6
        System.out.println(gridTraveler(18,18)); //exprected: 2333606220
        
        //for optimization know that: num of ways to travel a (r,c) grid is = num of ways to travel a (c,r) grid 
        // ie gridTraveler(5,9) = gridTraveler(9,5)
        System.out.println(gridTraveler(9,5)); 
        System.out.println(gridTraveler(5,9)); 


    }

}


