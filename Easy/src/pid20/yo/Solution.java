package pid20.yo;

/* pid20
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
1.左括号必须用相同类型的右括号闭合。
2.左括号必须以正确的顺序闭合。
3.注意空字符串可被认为是有效字符串。

*  */

import java.util.HashMap;
/* 括号的三种情况：
* 1.空字符串，即0个括号，这显然是“括号匹配”的；
* 2.对称式的分布
* 3.成对、紧跟式的分布
*  */
public class Solution {

    public boolean isValid_duiChen( HashMap<String,String> map, String s ){
        int length = s.length(); //获取字符串的长度
        /* 当所有括号处于“对称式分布”时，
         * 任意一对匹配的括号它们(左、右括号)的下标之和 必等于 字符串长度-1
         *
         *  */
        int indexSum = length-1;

        //暂存每次判断的结果，若截取的字符串长度非空，则必然是true
        StringBuilder sb = new StringBuilder( "" );

        for( int i=0; (i<length/2); i++ ){ //对称式的判断
            String left = s.substring( i,i+1 );
            String right_possible = s.substring( indexSum-i, (indexSum-i+1) ); //可能的：对称式的右括号
            String right_really = map.get( left );

            if( !right_possible.equals(right_really) ){
                sb.append( "no" );
            }
            //单独判断中间
            if( i==(length/2)-1 ){ //中间位置为 length/2; 而 (length/2)-1 是中间位置紧紧挨着的左移一位
                String left_middle = s.substring( i,i+1 );
                String right_middle_really = map.get( left_middle );
                String middle = s.substring( length/2, (length/2)+1 );
                if( !middle.equals(right_middle_really) ){
                    sb.append( "no" );
                }
            }
        }

        boolean rst = (sb.toString().contains("no")) ? false : true;
        return rst;
    }

    public boolean isValid_nextTo( HashMap<String,String> map, String s ){ //紧跟着的 nextTo
        StringBuilder sb = new StringBuilder();

        for( int i=0, length=s.length(); i<(length-1); i+=2 ){ //不让i取到(length-1)最后一个下标
            char left = s.charAt(i);
            char right_possible_char =s.charAt(i+1);
            String right_really = map.get( String.valueOf(left) );
            String right_possible = String.valueOf( right_possible_char );

            if( !right_possible.equals(right_really) ){
                sb.append( "no" );
            }
        }
        boolean rst = (sb.toString().contains("no")) ? false : true;
        return rst;
    }



    public boolean isValid(String s){
        if( s.length()==0 ){ //如果字符串长度为0，则这字符串是空字符串，有0个括号，也算是“匹配”的
            return true;
        }

        boolean rst = false;
        //构造括号的对应关系
        HashMap<String, String> map = new HashMap<>();
        map.put( "(",")" ); //圆括号
        map.put( "[","]" ); //方括号
        map.put( "{","}" ); //花括号

        String left = s.substring( 0,1 );
        String right_s = s.substring( 1,2 );
        String right_map = map.get( left );

        if( !right_s.equals(right_map) ){
            rst = isValid_duiChen( map,s );
        }else{
            rst = isValid_nextTo( map,s );
        }
        return rst;
    }
}
