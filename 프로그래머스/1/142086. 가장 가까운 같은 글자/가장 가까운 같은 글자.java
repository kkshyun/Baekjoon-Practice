import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, 0);
        for(int i = 0 ; i < s.length() ; i++) {
            char find = s.charAt(i);
            for(int j = i-1; j >= 0; j--) {
                char c = s.charAt(j); 
                if(find == c) {
                    answer[i] = i-j;
                    break;
                }
            }
            if(answer[i] == 0)
                answer[i] = -1;       
        }
        return answer;
    }
}