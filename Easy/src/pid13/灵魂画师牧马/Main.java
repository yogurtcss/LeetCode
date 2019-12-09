package pid13.灵魂画师牧马;

import pid13.灵魂画师牧马.Solution;

public class Main {

    public static void test(){
        Solution solu = new Solution();
        String strX = "MCMXCIV";

        long begin = System.currentTimeMillis();
        System.out.println( solu.romanToInt(strX) );
        long end = System.currentTimeMillis();
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }
}
