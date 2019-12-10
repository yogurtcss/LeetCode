package pid14.yo;

import pid14.yo.Solution;

public class Main {
    public static void test(){
        Solution solu = new Solution();
        String[] strs = { "" };
        long begin = System.currentTimeMillis();
        String rst = solu.longestCommonPrefix(strs);
        long end = System.currentTimeMillis();

        System.out.println( rst );
        System.out.println( rst.equals("") );
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }
}
