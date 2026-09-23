import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        long sumQueue1 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i : queue1) {
            sum += i;
            q1.offer(i);
            sumQueue1 += i;
        }
        for(int i : queue2) {
            sum += i;
            q2.offer(i);
        }
        if (sum % 2 != 0)
            return -1;
        long target = sum/2;
        
        int count = 0;
        int limit =  (queue1.length + queue2.length) * 2;
        while(sumQueue1 != target) {
            if(limit == 0)
                    return -1;
            if(sumQueue1 > target) {
                int poll = q1.poll();
                sumQueue1 -= poll;
                q2.offer(poll);
            } else if(sumQueue1 < target) {
                int poll = q2.poll();
                sumQueue1 += poll;
                q1.offer(poll);
            }
            limit--;
            count++;
        }
        
        return count;
    }
}