//memorization

import java.util.HashMap;

public class Fibonaaci {

    static HashMap<Long, Long> memo = new HashMap<>();
    static long fib(int n){
        if(n<=2) return 1L;

        if(memo.containsKey((long)n)){ //if u dont type cast it'll return false
            return memo.get((long)n);
        }

        long fibResult = fib(n-1) + fib(n-2);
        memo.put((long)n, fibResult);

        return fibResult;
    }

    public static void main(String[] args) {
        
        
        
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(50));

    }
}


