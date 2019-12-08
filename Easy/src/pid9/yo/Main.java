package pid9.yo;

import pid9.yo.Solution;
import pid9.yo.Solution2;

public class Main {
    public static void test(){
        int x = -111;
        //Solution solu = new Solution();
        Solution solu2 = new Solution();
        long begin = System.currentTimeMillis();
        boolean b = solu2.isPalindrome(x);
        long end = System.currentTimeMillis();

        System.out.println( b );
        System.out.println(); //换行
        System.out.println( "耗时："+(end-begin)+" ms" );
        System.out.println( "---------------------------" );
    }

    public static void main(String[] args) {
        test();
    }
}
