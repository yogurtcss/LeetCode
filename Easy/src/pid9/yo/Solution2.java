package pid9.yo;

/* 回文数：不使用字符串的比较方法
1.如果是负数，则一定不是回文数，直接返回false
2.如果是正数：反转该数，并与原数比较，返回比较结果
*  */

public class Solution2 { //powered by 大神灵魂画师牧码
    public boolean isPalindrome(int x){
        if( x<0 ){
            return false;
        }else{
            int rst = 0;
            //用num先代替x，然后就在while循环中对num除以10
            int num = x; //保护原数x，因为x还要和rst比较
            while( num!=0 ){
                int pop = num%10;
                rst = rst*10 + pop;
                // x = x/10;    //不应这样写！！x被改变了
                num /= 10; //保护原数x，因为x还要和rst比较
            }
            return rst==x;
        }
    };
}