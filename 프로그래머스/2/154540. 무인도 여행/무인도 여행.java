import java.util.*;

class Solution {
    static int[][] graph;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int[] solution(String[] maps) {
        List<Integer> result = new ArrayList<>();
        graph = new int[maps.length][maps[0].length()];
        for(int i = 0 ; i < maps.length ; i++) {
            String str = maps[i];
            for(int j = 0 ; j < str.length(); j++) {
                if(str.charAt(j) == 'X')
                    graph[i][j] = 0;
                else
                    graph[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0 ; i < graph.length ; i++) {
            for(int j = 0 ; j < graph[0].length ; j++) {
                if(graph[i][j] != 0) {
                    result.add(bfs(i,j));
                }
            }
        }
        if(result.size() == 0)
            return new int[]{-1};
        
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static int bfs(int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        int sum = graph[row][col];
        queue.offer(new int[]{row, col});
        graph[row][col] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if(nr < 0 || nc < 0 || nr >= graph.length || nc >= graph[0].length)
                    continue;
                if(graph[nr][nc] != 0) {
                    sum += graph[nr][nc];
                    graph[nr][nc] = 0;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return sum;
    }
}