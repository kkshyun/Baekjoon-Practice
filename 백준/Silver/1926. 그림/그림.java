import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int connectionCount = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(graph[i][j] == 1) {
                    connectionCount++;
                    max = Math.max(max,bfs(i,j));
                }
            }
        }
        System.out.println(connectionCount);
        System.out.println(max);
    }
    
    static int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        graph[x][y] = 0;
        int count = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            count++;
            for(int i = 0; i < 4 ; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return count;
    }
}