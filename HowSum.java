import java.util.*;

public class HowSum {

    static HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>(); 

    static ArrayList<Integer> howSum(int targetSum, int[] nums){

        if(targetSum==0) return new ArrayList<Integer>();
        if(targetSum<0) return null;

        if(memo.containsKey(targetSum)){
            return memo.get(targetSum);
        }

        for (int i = 0; i < nums.length; i++) {

            ArrayList<Integer> ans = howSum(targetSum-nums[i],nums);

            if (ans!=null){
                ans.add(nums[i]);
                return ans;
            }
            else{
                //if canSum returns null then that means targetSum-nums.get(i) num cannout be made using sum of numnbers in arraylist 
                memo.put(targetSum-nums[i], ans);

                //fun fact all the keys in "memo" will have value "null" caz if its a arraylist then it'll go inside "if" and end the recusive calls
            }
        }

        return null;
        
    }

    public static void main(String[] args) {
        
        int[] nums = {7,14};

        System.out.println(howSum(50, nums));
        System.out.println(howSum(10, nums));
        System.out.println(howSum(7, nums));
        System.out.println(howSum(300, nums)); //need memorization to run this efficiently 

    }
}
