package pid20.yo;

import java.util.Stack; //栈！我居然没有想到有这个东西！还傻乎乎地去用ArrayList<T>！我佛了
import java.util.HashMap;

/* 栈stack，又名堆栈

▲ Stack类的用法
* boolean empty()：测试堆栈是否为空。
* Object peek()：查看堆栈顶部的对象，但不从堆栈中移除它。
* Object pop()：移除堆栈顶部的对象，并作为此函数的值返回该对象。
* Object push(Object element)：把项压入堆栈顶部。
* int search(Object element)：返回对象在堆栈中的位置，以 1 为基数

*  */

public class Solution3 {
    public boolean isValid(String s){
        //左右括号进行对应(映射)的map
        HashMap<Character,Character> map = new HashMap<>();
        //构造括号的对应关系
        map.put( '(',')' ); //圆括号
        map.put( '[',']' ); //方括号
        map.put( '{','}' ); //花括号

        //只存放左括号的栈， stack left左_括号
        Stack<Character> stackLeft = new Stack<>();
        for( int i=0, length=s.length(); i<length; i++ ){ //遍历原字符串，取每一个字符 s.charAt(下标i)
            Character oneCh = s.charAt(i);
            //map的键是 左括号
            if( map.containsKey(oneCh) ){ //如果当前字符是左括号
                stackLeft.push(oneCh); //让此左括号入栈
            }else{ //如果当前字符是右括号
                //以下的逻辑，全是关于 “右括号”的逻辑了
                if( stackLeft.empty() ){ // 进到这里，表示还有右括号待匹配，但我左括号的栈已经弹空了
                    return false; //直接返回false
                }
                //Object pop()：移除堆栈顶部的对象，并作为此函数的值返回该对象。
                Character lastCh = stackLeft.pop(); //栈顶元素即 最后一个左括号
                if( !map.get(lastCh).equals(oneCh) ){ //如果当前的右括号与 最后一个左括号 不匹配，
                    return false; //又直接false了
                }
            }
        }
        /* 理论上到了这里，栈应该是空了(匹配的左括号全弹了出去)
        * 栈空吗？true
        * 否则(说明还有左括号没被匹配成功)就false
        *  */
        return ( stackLeft.empty() ? true:false );
    }
}
