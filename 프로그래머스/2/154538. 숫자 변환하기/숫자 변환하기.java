import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] dist = new int[y+1];
        Arrays.fill(dist,-1);
        dist[0] = 0;
        dist[x] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(x);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int next = curr + n;
            if(next < dist.length && dist[next] == -1) {
                dist[next] = dist[curr] + 1;
                queue.offer(next);
            }
            next = curr*2;
            if(next < dist.length && dist[next] == -1) {
                dist[next] = dist[curr] + 1;
                queue.offer(next);
            }
            
            next = curr*3;
            if(next < dist.length && dist[next] == -1) {
                dist[next] = dist[curr] + 1;
                queue.offer(next);
            }
            
            if(dist[y] != -1)
                return dist[y];
            
        }
        
        return -1;
    }
}