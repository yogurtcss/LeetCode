package problems.pid14.yo;

public class Main {
    public static void test(){
        //Solution solu = new Solution();
        Solution2 solu2 = new Solution2();
        String[] strs = { "" };
        long begin = System.currentTimeMillis();
        //String rst = solu.longestCommonPrefix(strs);
        String rst = solu2.longestCommonPrefix(strs);
        long end = System.currentTimeMillis();

        System.out.println( rst );
        System.out.println( rst.equals("") );
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }
}
