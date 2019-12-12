package pid20.yo;

import pid20.yo.Solution;

public class Main {
    public static void test(){
        String s = "{[()]]";
        Solution solu = new Solution();
        long begin = System.currentTimeMillis();
        boolean rst = solu.isValid(s);
        long end = System.currentTimeMillis();
        System.out.println( rst );
        System.out.println( "------------" ); //换行
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }

}
