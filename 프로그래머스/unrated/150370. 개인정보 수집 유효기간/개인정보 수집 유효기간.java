import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> abc = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for(String str : terms){
            String[] term = str.split(" ");
            int a = Integer.valueOf(term[1]);
            abc.put(term[0], a);
        }
        int year = 28*12;
        int month = 28;
        
        String[] t = today.split("[.]");

        int td = 0;
        for(int i = 0; i<3; i++){
            if(i == 0){
                td += Integer.valueOf(t[i])*year;
            }else if(i == 1){
                td += (Integer.valueOf(t[i])-1)*month;
            }else{
                td += Integer.valueOf(t[i]);
            }
        }
        int index = 1;
        for(String priv : privacies){
            String[] dates = priv.split(" ");
            String date = dates[0];
            String key = dates[1];
            
            int temp = 0;
            
            String[] dat = date.split("[.]");
            for(int i = 0; i<3; i++){
                if(i==0){
                    temp += Integer.valueOf(dat[i])*year;
                }else if(i==1){
                    temp += (Integer.valueOf(dat[i])-1)*month;
                }else{
                    temp += Integer.valueOf(dat[i]);
                }
            }
            temp += abc.get(key)*28;
            if (temp <= td){
                answer.add(index);
            }
            index++;
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i<ans.length; i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}