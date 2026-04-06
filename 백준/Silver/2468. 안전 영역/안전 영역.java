import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        StringTokenizer st;
        int maxHeight = 0;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N ; j++) {
                int height = Integer.parseInt(st.nextToken());
                graph[i][j] = height ;
                maxHeight = Math.max(maxHeight, height);
            }
        }

        int max = 0;
        for(int k = 0; k < maxHeight; k++) {
            visited = new boolean[N][N];
            int connectionCount = 0;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N ; j++) {
                    if(graph[i][j] > k && !visited[i][j]) {
                        connectionCount++;
                        bfs(i,j,k);
                    }
                }
            }
            max = Math.max(connectionCount, max);
        }
        System.out.println(max);
    }
    
    static void bfs(int x, int y, int k) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4 ; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(graph[nx][ny] > k && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}