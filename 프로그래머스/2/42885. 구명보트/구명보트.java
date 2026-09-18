import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Integer[] p = new Integer[people.length];
        for(int i = 0 ; i < p.length ; i++) {
            p[i] = people[i];
        }
        Arrays.sort(p, Collections.reverseOrder());
        int start = 0;
        int end = p.length-1;
        int count = 0;
        while(start < end) {
            if(p[start] + p[end] > limit) {
                count++;
                start++;
            } else {
                count++;
                start++;
                end--;
            }
        }
        if(start == end)
            count++;
        return count;
    }
}