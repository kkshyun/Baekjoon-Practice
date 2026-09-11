import java.util.*;
class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    boolean[][] visited;
    int endR;
    int endC;
    public int solution(int[][] maps) {
        // BFS
        endR = maps.length;
        endC = maps[0].length;
        visited = new boolean[endR][endC];
        return bfs(maps, 0, 0);
    }
    
    int bfs(int[][] graph, int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 1});
        visited[startR][startC] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int currentR = temp[0];
            int currentC = temp[1];
            int currentDepth = temp[2];
            if(currentR == endR -1 && currentC == endC -1)
                return currentDepth;
            for(int i = 0 ; i < 4; i++) {
                int nr = currentR + dr[i];
                int nc = currentC + dc[i];
                if(nr < 0 || nr >= endR || nc < 0 || nc >= endC)
                    continue;
                if(graph[nr][nc] == 0)
                    continue;
                if(visited[nr][nc])
                    continue;
                
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, currentDepth+1 });
            }
        }
        return -1;
    }
    
}