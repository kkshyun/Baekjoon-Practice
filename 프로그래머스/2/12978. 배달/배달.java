import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        } 
        for(int i = 0; i < road.length; i++) {
            graph[road[i][0]].add(new int[]{road[i][1], road[i][2]});
            graph[road[i][1]].add(new int[]{road[i][0], road[i][2]});
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //dikstra
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));
        dist[1] = 0;
        pq.offer(new int[]{1,0});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(dist[curr[0]] < curr[1])
                continue;
            dist[curr[0]] = curr[1];
            for(int[] next : graph[curr[0]]) {
                if(dist[next[0]] > curr[1] + next[1]) {
                    dist[next[0]] = curr[1] + next[1];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        int count = 0;
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] <= K)
                count++;
        }
        return count;
    }
}