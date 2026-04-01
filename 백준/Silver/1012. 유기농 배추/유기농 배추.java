import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] graph;
    static int M, N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph = new boolean[M][N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }
            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int l = 0 ; l < N ; l++) {
                    if(graph[j][l]) {
                        bfs(j, l);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        graph[x][y] = false;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx < M && ny < N && nx >= 0 && ny >= 0) {
                    if(graph[nx][ny]) {
                        graph[nx][ny] = false;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}