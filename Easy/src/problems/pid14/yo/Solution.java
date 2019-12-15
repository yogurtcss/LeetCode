package problems.pid14.yo;

/* 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

输入: ["flower","flow","flight"]
输出: "fl"

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

*  */


import java.util.HashMap;
import java.util.Set;

public class Solution {
    public String cmpTwoString( String s1, String s2 ){
        // String cmpRst = ""; //这样做是错误的！String是不可变(不可追加字符)的！
        /* String是不可变的，若要设置字符串形式的变量，应设成 StringBuilder类型的！
        * 因为 StringBuilder是可变的；
        * 最后返回值的时候，将StringBuilder的结果转为 String，方法为：
        * StringBuilder实例对象.toString()
        *  */
        StringBuilder cmpRst = new StringBuilder();
        for( int i=0,length=s1.length(); i<length; i++ ){ //在此for循环内，一定会遍历完s1字符串的
            if(  (i+1<s2.length()) && (s1.substring(i,i+1).equals(s2.substring(i,i+1))) ){ //逐一比较s1、s2的每一个字符
                cmpRst.append( s1.substring(i,i+1) );
            }else if( (i+1==s2.length()) ){ //当比较到s2字符串的最后一个字符时
                String temp = s2 + ""; //关键！给s2的末尾再添加一个空字符！
                if( s1.substring(i,i+1).equals(temp.substring(i,i+1)) ){ //然后再比较 s2字符串的最后一个字符时
                    cmpRst.append( s1.substring(i,i+1) );
                }
            }else{ //如果都没有相等的，就返回空字符串
                cmpRst.append("");
            }
        }
        return ( cmpRst.toString() );
    }

    //初始化 公共前缀长度的值
    public void initCount( HashMap<String,Integer> strCount, String cmpRst ){
        if( strCount.containsKey(cmpRst)==false ){
            strCount.put( cmpRst, 0 );
        }
    }
    //更新 公共前缀长度的值
    public void updateCount( HashMap<String,Integer> strCount, String cmpRst ){
        if( strCount.containsKey(cmpRst)==true ){
            int old = strCount.get(cmpRst);
            strCount.remove(cmpRst);
            strCount.put( cmpRst,(old+1) );
        }
    }
    //strCount中 出现次数最多的，就是最大长度的公共前缀

    //获取 出现次数最多的——最大长度的公共前缀
    public String getMaxCount( HashMap<String,Integer> strCount ){
        int max = 0;
        String rst = "";
        Set<String> keySet = strCount.keySet();
        for( String one : keySet ){
            if( strCount.get(one)>max ){
                max = strCount.get(one);
                rst = one; //把 出现次数最多的 公共前缀 暂存在 rst中
            }
        }
        return rst;
    };


    public String longestCommonPrefix(String[] strs){
        HashMap<String,Integer> strCount = new HashMap<>();
        String rst = "";
        if( strs.length==1 ){
            return strs[0];
        }

        for( int i=0,length=strs.length; i<length; i++ ){
            for( int j=i+1; j<length; j++ ){
                String cmpRst = cmpTwoString( strs[i],strs[j] ); //两两比较，并取出公共前缀
                //System.out.println( cmpRst );
                initCount( strCount, cmpRst );
                updateCount( strCount, cmpRst );
            }
        }

//        Set<String> keySet = strCount.keySet();
//        for( String one : keySet ){
//            System.out.println( one+"="+strCount.get(one) );
//        }

        System.out.println( "------------" );
        rst = getMaxCount( strCount );
        return rst;
    }
}