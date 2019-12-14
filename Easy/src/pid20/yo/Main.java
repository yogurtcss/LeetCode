package pid20.yo;

import pid20.王尼玛.Solution;
import pid20.yo.Solution3;

public class Main {
    public static void test(){
        String s = "()";

        Solution solu = new Solution();
        //Solution2_notFinished solu2 = new Solution2_notFinished();
        Solution3 solu3 = new Solution3();

        long begin = System.currentTimeMillis();
        boolean rst = solu3.isValid(s);
        long end = System.currentTimeMillis();
        System.out.println( rst );
        System.out.println( "------------" ); //换行
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }

}
