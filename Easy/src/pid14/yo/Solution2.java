package pid14.yo;

public class Solution2 {
    public String longestCommonPrefix(String[] strs){
        if( strs.length==0 ){ //如果字符串长度为0，那么这是空字符串，直接返回
            return "";
        }
        String ans = strs[0]; // “预定结果”

        //i<strs.length 表示，下标i能取到 strs.length-1 即下标i能取到 (长度-1)的值，这是对的
        for( int i=1; i<strs.length; i++ ){ //ans 与后面的字符串进行比较
            int j = 0; //j不在for循环中；这用来记录 最大长度的公共前缀的 索引【终点】
            for( ; j<ans.length()&&j<strs[i].length(); j++ ){ // j不超过 ans、strs[i]的长度
                if( ans.charAt(j)!=strs[i].charAt(j) ){ //ans、strs[i] 在共同的第j处字符不相等时，
                    break; //直接跳出整个循环
                }
            }
            //j携带了 最大长度的公共前缀的 索引【终点】，即 j-1
            ans = ans.substring( 0,j ); //更新 “预定结果”
            if( ans.equals("") ){ //如果最后得出的结果是空字符串，则直接返回了
                return ans;
            }
        }

        //直接返回“预定结果”，或返回 正常比较后的结果
        return ans;
    }
}
