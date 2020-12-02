package Dynamic;

import java.util.Arrays;

public class Fb {

    private static  int m;
    private static long[] memo;

    public static long fb(int n){

        m++;

        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(memo[n] == -1){
            memo[n] = fb(n - 1) + fb(n - 2);
        }
        return memo[n];
    }
    public static long fb2(int n){
        memo = new long[n + 1];
        Arrays.fill(memo,-1);
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        m = 0;
        int n = 100;
        memo = new long[n + 1];
        Arrays.fill(memo,-1);

        long startTime=System.nanoTime();   //获取开始时间
        System.out.println(Fb.fb2(n));
        long endTime=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
        System.out.println("Times : " + m);
    }
}
