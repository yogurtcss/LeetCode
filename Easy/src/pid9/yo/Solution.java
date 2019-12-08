package pid9.yo;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

*  */
import java.util.ArrayList;

public class Solution {
    public String reverse( int x ){ //不讨论x=0时的情况，在public boolean isPalindrome(int x)中再讨论
        if( x<0 ){
            x = x*(-1);
        }
        ArrayList<String> list = new ArrayList<>();

        while( x!=0 ){
            int pop = x%10; //从最低位往最高位拆数字
            list.add( String.valueOf(pop) );
            x = x/10;
        };

        //String是不可变的，而StringBuilder是可变的
        StringBuilder temp = new StringBuilder();
        for( String one :list ){
            temp.append(one);
        };
        String reverseStr = new String( temp ); //以 StringBuilder实例对象构建的字符串

        return reverseStr;
    }


    public boolean isPalindrome(int x){
        String xStr = String.valueOf( x );
        if( x==0 ){ //0也是回文数！！直接返回true！！忘了这一点！
            return true;
        }else if( x<0 ){
            //经过reverse()方法处理后的(反转的)字符串，是不带负号的；故需在末尾添加负号
            String reverseStr = reverse(x)+"-";
            return xStr.equals( reverseStr );
        }else{
            String reverseStr = reverse(x);
            return xStr.equals( reverseStr );
        }
    };
}