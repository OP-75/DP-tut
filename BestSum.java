import java.util.ArrayList;
import java.util.HashMap;

public class BestSum {

    static HashMap<Integer, ArrayList<Integer>> memo = new HashMap<>();


    //IMPORTANT NOTE!!!! - REMEBER ARRAYLIST IS A POINTER SO EVERYTIME U RETURN OR 
    // ASSIGN IT TO SOME OTHER VARIABLE MAKE ITS COPY!!!!!! OTHERWISE U WILL DO ALL OPERATIONS 
    // ON A SINGLE LIST AND GET WRONG ANS


    static ArrayList<Integer> bestSum(int targetSum, int[] nums) {

        
        if (targetSum == 0){
            return new ArrayList<Integer>();
        }
        
        if (targetSum < 0){
            return null;
        }
        
        if (memo.containsKey(targetSum)) {
            //IMPORTANT NOTE!!!! - REMEBER ARRAYLIST IS A POINTER SO EVERYTIME U RETURN OR 
            // ASSIGN IT TO SOME OTHER VARIABLE MAKE ITS COPY!!!!!! OTHERWISE U WILL DO ALL OPERATIONS 
            // ON A SINGLE LIST AND GET WRONG ANS
            ArrayList<Integer> hashAns = memo.get(targetSum);
            return makeCopy(new ArrayList<Integer>(), hashAns);
        }
        

        ArrayList<Integer> shortestSolution = null;
        for (int i = 0; i < nums.length; i++) {

            ArrayList<Integer> tmpAns = bestSum(targetSum - nums[i], nums);

            if (tmpAns != null) {
                tmpAns.add(nums[i]);

                // if curr ans is shorter than the shortestSolution then update it
                if (shortestSolution == null || shortestSolution.size() > tmpAns.size()) {
                    //IMPORTANT NOTE!!!! - REMEBER ARRAYLIST IS A POINTER SO EVERYTIME U RETURN OR 
                    // ASSIGN IT TO SOME OTHER VARIABLE MAKE ITS COPY!!!!!! OTHERWISE U WILL DO ALL OPERATIONS 
                    // ON A SINGLE LIST AND GET WRONG ANS
                    shortestSolution = makeCopy(new ArrayList<Integer>(), tmpAns);
                }

                tmpAns = null;
            }

        }

        // store the shortest solution for target in memo to save time of recalculations
        memo.put(targetSum, makeCopy(new ArrayList<Integer>(), shortestSolution));
        // please note that now for every key the value can be null or a array if the
        // solution exists
        // (this was not the xase in howSum or canSum)

        return shortestSolution;

    }

    //IMPORTANT NOTE!!!! - REMEBER ARRAYLIST IS A POINTER SO EVERYTIME U RETURN OR 
    // ASSIGN IT TO SOME OTHER VARIABLE MAKE ITS COPY!!!!!! OTHERWISE U WILL DO ALL OPERATIONS 
    // ON A SINGLE LIST AND GET WRONG ANS
    static ArrayList<Integer> makeCopy(ArrayList<Integer> copy, ArrayList<Integer> original){
        copy.clear();

        for (Integer i : original) {
            copy.add(i.intValue());
        }

        return copy;
    }


    public static void main(String[] args) {

        // in bestSum() u have to do the full tree exploration unlike howSum and canSum
        // which just return the first answer they find
        // so bestSum is much more time consuming


        
        System.out.println(bestSum(5, new int[] { 1, 4 }));
        memo.clear();

        System.out.println(bestSum(8, new int[] { 1, 4, 5 }));
        memo.clear();

        System.out.println(bestSum(7, new int[] { 7, 14, 1 }));
        memo.clear();

        System.out.println(bestSum(21, new int[] { 7, 14, 1 }));
        memo.clear();

        // need memorization to run this efficiently
        System.out.println(bestSum(100, new int[] { 1, 5, 25 }));
        memo.clear();
        
        System.out.println(bestSum(300, new int[]{7,14,1}));
        memo.clear();
        
    }
}
