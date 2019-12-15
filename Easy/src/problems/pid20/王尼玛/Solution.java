package problems.pid20.王尼玛;

import java.util.HashMap;
import java.util.Stack;

/* 大神王尼玛的代码！！
* 思路与昨晚 JavaScript的思路一模一样
* 只是换了用栈来实现！！
*  */

/* Solution2_notFinished




*  */


public class Solution {
    public boolean isValid(String s) {
        if(s==null || "".equals(s)) {
            return true;
        }
        //用栈保存 (，[，{
        Stack<Character> stack = new Stack<Character>();
        //map中保存的是 ):(, ]:[,}:{
        //当遍历到 )时候就会去map中找对应的value，也就是(
        //再用这个value和stack弹出的元素比较，如果相等则匹配上，不等则返回false
        //这里也可以用数组来存，我为了简单就用map表示了
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            //如果map中不包含 (,[,{，就将这个字符放入栈中
            if(!map.containsKey(c)) {
                stack.add(c);
            } else {
                //如果遍历的字符不再map中，也就是说这个字符是),],}，那么就要跟栈中的元素比较
                //首先要判断栈是否为空，如果输入的字符是 )() ，那么当遍历到第一个)时，栈为空
                if(stack.size()==0) {
                    return false;
                }
                //取出栈顶的元素
                Character tmp = stack.pop();
                //假设当前遍历到的元素是 ]，那么从map中取到的value就是 [
                //如果栈顶的元素是 (，则不匹配返回false，否则继续
                if(map.get(c)!=tmp) {
                    return false;
                }
            }
        }
        //返回的时候还要判断栈是否为空
        //如果输入的字符串是 (((，那么最后栈就不为空
        return (stack.empty()? true : false);
    }
}