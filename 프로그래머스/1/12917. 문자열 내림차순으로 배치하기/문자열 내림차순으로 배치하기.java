import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        
        char[] arranged = new char[charArr.length];
        for(int i = 0; i<arranged.length; i++){
            arranged[i] = charArr[arranged.length - 1 -i];
        }
        
        s = String.valueOf(arranged);
        return s;
    }
}