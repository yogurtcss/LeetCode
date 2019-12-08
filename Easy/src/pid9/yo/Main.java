package pid9.yo;

import pid9.yo.Solution;

public class Main {
    public static void test(){
        int x = 0;
        Solution solu = new Solution();
        long begin = System.currentTimeMillis();
        boolean b = solu.isPalindrome(x);
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
