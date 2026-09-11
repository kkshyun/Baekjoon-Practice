import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
            pq.offer(p);
        }
        for(int i = 0 ; i < priorities.length ; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            int order = p[0];
            int priority = p[1];
            if(pq.peek() <= priority) {
                count++;
                pq.poll();
                if(order == location) {
                    return count;
                }
            } else {
                queue.offer(new int[]{order, priority});
            }
        }
        
        return count;
    }
}