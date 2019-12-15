package problems.pid13.灵魂画师牧马;

import java.util.HashMap;

/*
首先将所有的组合可能性列出并添加到哈希表中
然后对字符串进行遍历，由于组合只有两种，一种是 1 个字符，一种是 2 个字符，其中 2 个字符优先于 1 个字符
先判断两个字符的组合在哈希表中是否存在，存在则将值取出加到结果 ans 中，并向后移 2 个字符。不存在则将判断当前 1 个字符是否存在，存在则将值取出加到结果 ans 中，并向后移 1 个字符
遍历结束返回结果 ans

思路亮点：
1.遍历原字符串时：
    不是拆分每一个字符进字符数组，然后遍历此字符数组；
    而是：针对此字符串【截取指定范围】的子字符串进行for的遍历：(在一开始并未指定增加的步长！！)

    ▲ 如取2个字符时的情况：
    s.substring(i,i+2)    //起始索引为i(包括)， 结束索引为i+2(不包括)
    每次都截取 [i,i+1] 即包含2个字符的 字符串进行遍历！！
    这时才指定 增长的步长：每次跳2个字符串！ i=i+2！
    注意：每次截取【含2个字符的子字符串】前，需判断 下一个字符i+1是否越界(索引i+1是否大于了字符串长度length)

2.检查map中是否包含指定键时：
    不是 取出map的keySet(即 键的集合)，然后遍历此keySet，一一作比较；
    而是 直接调用方法 map实例对象.contains(key) 判断是否存在指定的键名 key！！

*  */


public class Solution {
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
        HashMap<String,Integer> strIntMap = getDictMap();
        int ans = 0;

        /* public String substring( int beginIndex  [,int endIndex 可选的] )
        * 返回某字符串中【指定索引 或起始、结束区间内的】子字符串；(即 返回某字符串内指定范围的一部分字符串)
        *   ▲ beginIndex -- 起始索引(包括), 索引从 0 开始；
        *     - 若不指定endIndex，则默认返回从 beginIndex直到原字符串的末尾
        *   ▲ endIndex -- 可选的，结束索引(不包括)。
        *
        *  */
        for( int i=0, length=s.length(); i<length; ){
            /* s.substring(i,i+2) 返回的是 原字符串中：区间[i,i+1]内的字符串；结束索引不包括i+2！！
            * String partStr = s.substring( i,i+2 );
            * 不要再另外用一个变量partStr暂存(含2个字符)字符串了，
            * 因为 下面还有 单独一个字符的情况！s.substring(i,i+1) 结束索引不包括i+1，所以这返回的是 第i个字符
            *  */
            // i+1<length，判断i的下一个字符 是否越界
            // map实例对象.contains(key) 判断是否存在指定的键名 key。
            if( (i+1<length) && (strIntMap.containsKey(s.substring(i,i+2)))  ){ //两个字符的情况
                ans = ans + strIntMap.get( s.substring(i,i+2) );
                i = i + 2; //跳两个字符
            }else{ //单个字符的情况
                ans = ans + strIntMap.get( s.substring(i,i+1) );
                i = i + 1; //跳一个字符
            }
        }

        return ans;
    }
}
