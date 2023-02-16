// import java.lang.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            for(int idx=0; idx<index; idx++){
                do{
                    str[i]++;
                    if(str[i]>'z'){
                        str[i] -= 26;
                    }
                }
                while(skip.contains(String.valueOf(str[i])));
            }
        }
        String ans = new String(str);
        return ans;
    }
}