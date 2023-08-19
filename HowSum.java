import java.util.*;

public class HowSum {

    static ArrayList<Integer> howSum(int target, int[] nums){

        if(target==0) return new ArrayList<Integer>();
        if(target<0) return null;

        for (int i = 0; i < nums.length; i++) {

            ArrayList<Integer> ans = howSum(target-nums[i],nums);

            if (ans!=null){
                ans.add(nums[i]);
                return ans;
            }
        }

        return null;
        
    }

    public static void main(String[] args) {
        
        int[] nums = {3,10};

        System.out.println(howSum(19, nums));
        System.out.println(howSum(10, nums));
        System.out.println(howSum(40, nums));

    }
}
