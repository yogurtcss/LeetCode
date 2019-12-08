package pid7.yo;

import pid7.yo.Solution;
import pid7.yo.Solution2;
import java.util.ArrayList;

public class Main {
    public static void test(){
        int x = -325;
        //Solution solu = new Solution();
        Solution2 solu2 = new Solution2();
        long begin = System.currentTimeMillis();
        //int rst = solu.reverse(x);
        int rst = solu2.reverse(x);
        long end = System.currentTimeMillis();

        System.out.println( rst );
        System.out.println(); //换一行
        System.out.println( "耗时："+(end-begin)+" ms" );
        System.out.println( "--------------------" );
    }

    public static void main(String[] args) {
        test();
    }
}
