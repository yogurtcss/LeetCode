package pid13.yo;

//不会做！


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

public class Solution_unfinished {
    public HashMap<String,Integer> getDictMap(){ //获取初始的映射表
        HashMap<String,Integer> strIntMap = new HashMap<>(); //键为罗马字符，值为整数
        //存入映射关系

        //最原始的映射。竖着看嗷 I-V-X-L，  C-D-M
        strIntMap.put( "I",1 );         strIntMap.put( "C",100 );
        strIntMap.put( "V",5 );         strIntMap.put( "D",500 );
        strIntMap.put( "X",10 );        strIntMap.put( "M",1000 );
        strIntMap.put( "L",50 );

        //特殊的映射。竖着看嗷
        strIntMap.put( "IV",4 );        strIntMap.put( "XL",40 );        strIntMap.put( "CD",400 );
        strIntMap.put( "IX",9 );        strIntMap.put( "XC",90 );        strIntMap.put( "CM",900 );

        return strIntMap;
    };



    public int romanToInt(String s){
        char[] chars = s.toCharArray();
        ArrayList<Character> charList = new ArrayList<>();
        for( char one : chars ){
            charList.add(one);
        }

        HashMap<String,Integer> strIntMap = getDictMap();
        Set<String> keyString = strIntMap.keySet();

        ArrayList<String> strList = new ArrayList<>();

        Iterator<Character> it = charList.iterator();
        while( it.hasNext() ){
            char t1 = it.next();
            String temp;
            if( t1!=charList.get( charList.size()-1 ) ){
                char t2 = it.next();
                //System.out.println( "-----"+t2 );
                temp = String.valueOf(t1)+String.valueOf(t2);
                System.out.println( "爷是temp！"+temp );
                for( String oneKey : keyString ){
                    if( temp.equals(oneKey) ){
                        strList.add(temp);
                    }
                }

            }else{ //此时到达最后一个元素了
                strList.add( String.valueOf(t1) );
            }
        }


        for( String one : strList ){
            System.out.println( one );
        }

        return 0;
    }
}
