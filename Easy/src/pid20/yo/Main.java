package pid20.yo;

public class Main {
    public static void test(){
        String s = "([)";
        //Solution solu = new Solution();
        Solution2_notFinished solu2 = new Solution2_notFinished();
        long begin = System.currentTimeMillis();
        boolean rst = solu2.isValid(s);
        long end = System.currentTimeMillis();
        System.out.println( rst );
        System.out.println( "------------" ); //换行
        System.out.println( "耗时："+(end-begin)+" ms" );
    }

    public static void main(String[] args) {
        test();
    }

}
