package pid1.yo;

import pid1.yo.Solution;
import java.util.Arrays;

public class Main {
    public static void test(){
        Solution solu = new Solution();
        int[] output;

        long begin = System.currentTimeMillis();
        output = solu.twoSum( new int[]{2, 7, 11, 15}, 17 );
        long end = System.currentTimeMillis();

        System.out.println( Arrays.toString( output ) );
        System.out.println(); //空一行
        System.out.println( "耗时："+(end-begin)+" ms" );
        System.out.println( "--------------------" );
    }


    public static void main(String[] args) {
        test();
    }
}
