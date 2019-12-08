package pid7.yo;

public class Solution2 { //powered by 灵魂画师牧马
    public int reverse( int x ){
        /* 使用数学的解法：
        * 循环拆开x的每一位数字(这是从最低位往高位拆的)
        * 在(按顺序)组合为新数字时，判断此新数字是否溢出
        *  */
        int ans = 0; //每次计算的结果
        while( x!=0 ){
            int pop = x%10; //每一次被拆开的数字，弹出去
            if( ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE && pop>7) ){
                return 0; //退出循环
            }
            if( ans<Integer.MIN_VALUE/10 || (ans==Integer.MAX_VALUE && pop<-8) ){
                return 0;
            }
            ans = ans*10 + pop;
            x = x/10;
        }
        return ans;
    }
}
