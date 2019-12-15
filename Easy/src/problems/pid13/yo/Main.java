package problems.pid13.yo;

public class Main {

    public static void test(){
        Solution_unfinished solu = new Solution_unfinished();
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
