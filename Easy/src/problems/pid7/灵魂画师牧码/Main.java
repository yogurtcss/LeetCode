package problems.pid7.灵魂画师牧码;

public class Main {
    public static void test(){
        int x = -325;
        Solution solu = new Solution();
        long begin = System.currentTimeMillis();
        int rst = solu.reverse(x);
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
