import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, M;
    static int[][] graph;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dist = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0; j < M ; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.print(bfs());
    }
    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        graph[0][0] = 0;
        dist[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            if(x == N-1 && y == M-1)
                return dist[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < N && ny < M && nx >= 0 && ny >=0) {
                    if(graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;
                        dist[nx][ny] = dist[x][y]+1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}