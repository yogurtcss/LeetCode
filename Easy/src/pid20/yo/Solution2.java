package pid20.yo;

import java.util.HashMap;
import java.util.ArrayList;
//使用StringBuilder 没有弹出栈的操作！

public class Solution2 {
    public boolean isValid(String s){
        //构造括号的对应关系
        HashMap<Character, Character> map = new HashMap<>();
        map.put( '(',')' ); //圆括号
        map.put( '[',']' ); //方括号
        map.put( '{','}' ); //花括号

        if( s.length()==1 ){ //如果只有单个字符，则必定不匹配
            return false;
        };

        ArrayList<Character> temp = new ArrayList<>();

        /* 检查map中是否包含指定键时：
        * 不是 取出map的keySet(即 键的集合)，然后遍历此keySet，一一作比较；
        * 而是 直接调用方法 map实例对象.contains(key) 判断是否存在指定的键名 key！！
        *  */
        for( int i=0,length=s.length(); i<length; i++ ){
            if( map.containsKey( s.charAt(i) ) ){
                temp.add( s.charAt(i) );
            }else{ //否则(即：不是左括号)，那么当前字符就是右括号
                //这里的else是对 右括号 的逻辑

                //此右括号必须与原“数组”中最后一个字符(最后一个左括号相匹配)

                /* 当前正在遍历的右括号 能与左括号匹配 ——
                * temp.remove(temp.size()-1)从原数组中移除最后一个元素，并返回这个被移除的元素！！
                * 恰好这个返回值【被移除的元素】可作为map的键！！
                *
                * 从map中取出这(temp中最后一个)左括号映射的右括号，与待遍历的右括号进行比较
                *
                *  */
                if( temp.size()-1>=0 && !map.get( temp.remove(temp.size()-1)).equals(s.charAt(i)) ) { //如果不成功
                    return false;
                }

            }
        }

        return temp.size()>0 ? false:true;
    };
}