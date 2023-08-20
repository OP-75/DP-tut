import java.util.*;
//can we produce the target sum using elements of the arr?
//repetion of elements is allowed so lets say target=10 & arr=[2] so this should return true since,
// 2+2+2+2+2 = 10
//also if target=7 & arr=[10,18,7] this is also true


public class CanSum {
    //rememebr in DP we start at the end!!!!!!!

    static HashMap<Integer, Boolean> memo = new HashMap<>();
    static boolean canSum(int targetSum, ArrayList<Integer> nums){

        if(targetSum==0) return true;

        if(targetSum<0) return false;

        if(memo.containsKey(targetSum)){ //we have encountred this targetSum in some other subtree no need to recalculate it
            return memo.get(targetSum);
        }
        
        for (int i = 0; i < nums.size(); i++) {
            
            if(canSum(targetSum-nums.get(i), nums)) { //if canSum returns true then return true, no need to check other branches/cases 
                return true;
            } 
            else{
                //if canSum returns false then that means targetSum-nums.get(i) num cannout be made using sum of numnbers in arraylist 
                memo.put(targetSum-nums.get(i), false);

                //funfact this memo obj will always have "false" for every key caz if canSum returns true we just end the function call/recursion
            }
           
        }
        
        return false; //the for loop executed all posibilites and still didnt return true so there is so such nums that add up to target



    }

    public static void main(String[] args) {

        //all nums provided should be +ve or 0

        //make arr of Integer[] & not int[]
        Integer[] nums = {7,14};
        // Integer[] nums = {2,1,1,1,1,1,1,11,1,1,11,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        ArrayList<Integer> al = new ArrayList<>();

        Collections.addAll(al,nums);

        
        System.out.println(canSum(7, al));
        System.out.println(canSum(8, al));
        System.out.println(canSum(300, al));

        //Brute forcetime complexity = O(n^m) n =arr.length, m=targetSum, see vid to know why
        // optimized time complexity = O(n*m)

    }
}
