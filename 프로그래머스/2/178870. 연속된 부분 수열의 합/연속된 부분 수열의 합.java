import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int result1 = 0;
        int result2 = 0;
        for(end = 0 ; end < sequence.length; end++) {
            sum += sequence[end];
            while(sum > k) {
                sum -= sequence[start];
                start++;
            }
            if((sum == k) && (len > end - start + 1)) {
                len = end - start + 1;
                result1 = start;
                result2 = end;
            }
        }
        
        int[] answer = {result1, result2};
        return answer;
    }
}