import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] dist;
    
    public int solution(String[] board) {
        char[][] graph = new char[board.length][board[0].length()];
        int startRow = -1;
        int startCol = -1;
        int findRow = -1;
        int findCol = -1;
        dist = new int[board.length][board[0].length()];
        for(int i = 0 ; i < board.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        for(int i = 0 ; i < board.length; i++) {
            String s = board[i];
            for(int j = 0 ; j < board[0].length(); j++) {
                graph[i][j] = s.charAt(j);
                if(s.charAt(j) == 'R') {
                    startRow = i;
                    startCol = j;
                }
                if(s.charAt(j) == 'G') {
                    findRow = i;
                    findCol = j;
                }
            }
        } 
    
        return bfs(startRow,startCol, graph, findRow, findCol);
    }
    
    
    static int bfs(int sr, int sc, char[][] g, int gr, int gc) {
        Queue<int[]> queue = new ArrayDeque<>();
        dist[sr][sc] = 0;
        queue.offer(new int[]{sr,sc});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            for(int i = 0 ; i < 4; i++) {
                int count = 1;
                while(true) {
                    int nr = poll[0] + dr[i]*count;
                    int nc = poll[1] + dc[i]*count;
                    if(nr < 0 || nc < 0 || nr >= g.length || nc >= g[0].length || g[nr][nc] == 'D') {
                        nr = poll[0] + dr[i]*(count-1);
                        nc = poll[1] + dc[i]*(count-1);
                        if(dist[nr][nc] == -1) {
                            dist[nr][nc] = dist[poll[0]][poll[1]] + 1;
                            queue.offer(new int[]{nr,nc});
                            if(nr == gr && nc == gc)
                                return dist[nr][nc];
                        }
                        break;
                    }
                    count++;
                }
            }
        }
        return -1;
    }
}