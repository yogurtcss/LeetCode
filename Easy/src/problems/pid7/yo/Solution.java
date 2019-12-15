package problems.pid7.yo;

/* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转

输入: 123
输出: 321

输入: -123
输出: -321

输入: 120
输出: 21
*  */

import java.lang.Math; //数学的包
import java.util.ArrayList; //ArrayList是实现 List 接口的动态数组
import java.util.Collections; //反转ArrayList中的元素

public class Solution {
    //计算原数字有多少位
    public int countPlaces( int x ){
        if( x<0 ){ //如果是个负数，先变为正数，然后再处理
            x = x*(-1);
        };
        /* String.valueOf(x) 返回int参数的字符串表示形式
        * str字符串实例对象.toCharArray() 字符串转换为字符数组
        *  */
        char[] cx = String.valueOf(x).toCharArray();
        // int length = ci.length; 返回此字符数组的长度，即 该整数的位数(有几位)
        return( cx.length ); //返回此字符数组的长度，即 该整数的位数(有几位)
    }

    //反转原数字
    public int reverseInt( int x ){
        int rst = 0; //最终结果

        //临时存储 商、余数
        ArrayList<Double> arrDouble = new ArrayList<>();
        int n = countPlaces(x); //得出该整数有几位，如传入x=100时，得到位数 n=3
        if( n==1 ){
            return x;
        }else{
            //初始的除数。如传入的x为123，则第一步需除以 100即 10^2 即 10^(n-1s)
            double temp = Math.pow(10, n-1);

            double rest = x; //余数部分
            while( temp!=1 ){ //取商、余数，并添加到arrDouble中
                double q = rest/temp; //商 quotient
                rest = x%temp;
                arrDouble.add(q);
                temp /= 10; //temp = temp/10;
                if( temp==1 ){
                    double last = rest/temp;
                    arrDouble.add(last);
                }
            }
            //将double转化为int，步骤：double -> String -> int
            ArrayList<Integer> arrInt = new ArrayList<>();
            for( double one : arrDouble ){
                //String.valueOf(one).toCharArray()[0] 先把原double数据变成字符串，后转为字符数组，只取其第一个元素(首位)
                String oneNum = String.valueOf( String.valueOf(one).toCharArray()[0] );
                //Integer.parseInt( oneNum ) 将字符型的首位 转换为int型
                arrInt.add( Integer.parseInt( oneNum ) );
            }
            //集合反转顺序
            Collections.reverse( arrInt );

            //最上面的全局变量temp已经在while循环中被除除除，削成1.0了
            //System.out.println( temp );
            double temp2 = Math.pow(10, n-1); //新建一个temp2，各位数字需乘回去的位
            for( int i=0,length=arrInt.size(); i<length; i++ ){
                // 3*100 + 2*10 + 1*1
                rst += arrInt.get(i)*temp2;
                temp2 /= 10;
            }
            //System.out.println( rst );
            return rst;
        }
    }

    public int reverse( int x ){ //我佛了，方法名必须要和 LeetCode代码模板上的方法名一致！！
        if( x<0 ){
            x = x*(-1); //先变成正数，传入给reverseInt处理完后，再乘以-1变回来
            return (reverseInt(x))*(-1);
        }else{
            return reverseInt(x);
        }
    }
}