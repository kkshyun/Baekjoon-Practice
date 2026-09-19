import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dc = {-1,1,0,0};
    static int[] dr = {0,0,-1,1};
    
    public int solution(int[][] land) {
        int result = 0;
        int group = 1; 
        visited = new int[land.length][land[0].length];
        for(int i = 0 ; i < land.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < land.length; i++) {
            for(int j = 0 ; j < land[0].length; j++) {
                if(land[i][j] == 1 && visited[i][j]==-1) {
                    map.put(group,bfs(i,j,land,group));
                    group++;
                }
            }
        }
        
        for(int i = 0 ; i < land[0].length; i++) {
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < land.length; j++) {
                if(visited[j][i]!= -1) {
                    if(!set.contains(visited[j][i])) {
                        set.add(visited[j][i]);
                        sum += map.get(visited[j][i]);
                    }
                }    
            }
            result = Math.max(result, sum);
        }
        return result;
    }
    
    static int bfs(int col, int row, int[][] l, int fill) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{col, row});
        visited[col][row] = fill;
        int count = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for(int i = 0 ; i < 4; i++) {
                int nc = dc[i] + poll[0];
                int nr = dr[i] + poll[1];
                if(nc < 0 || nr < 0 || nc >= l.length || nr >= l[0].length)
                    continue;
                if(l[nc][nr] == 1 && visited[nc][nr]==-1) {
                    queue.offer(new int[]{nc, nr});
                    visited[nc][nr] = fill;
                    count++;
                }
            }
        }
        return count;
    }
}