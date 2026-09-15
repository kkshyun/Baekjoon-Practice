import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int diff = Integer.MAX_VALUE;
        for(int i = 0 ; i < wires.length ; i++) {
            ArrayList<Integer>[] graph = new ArrayList[n+1];
            for(int j = 0 ; j < n+1; j++) {
                graph[j] = new ArrayList<>();
            }
            for(int j = 0 ; j < wires.length ; j++) {
                if(j == i)
                    continue;
                graph[wires[j][0]].add(wires[j][1]);
                graph[wires[j][1]].add(wires[j][0]);
            }
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            visited[wires[0][0]] = true;
            queue.offer(wires[0][0]);
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                count++;
                for(int next : graph[curr]) {
                    if(visited[next])
                        continue;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            count = Math.abs(count-(n-count));
            diff = Math.min(diff, count);
        }
        return diff;
    }
}