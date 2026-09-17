import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // lower bound
        long start = 1;
        long end = limit;
        while(start < end) {
            long mid = (start+end)/2;
            long time = 0;
            for(int i = 0 ; i < diffs.length; i++) {
                if(diffs[i] <= mid) {
                    time += times[i];
                } else {
                    time += (times[i] + times[i-1])*(diffs[i] - mid);
                    time += times[i];
                }
                if(time > limit)
                    break;
            }
            if(time <= limit) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int)start;
    }
}