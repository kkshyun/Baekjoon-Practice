import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int last = 0;
        int count = 0;
        for(int s : section) {
            if(last <= s) {
                last = s + m;
                count++;
            }
        }
        
        return count;
    }
}