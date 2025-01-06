import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int M,N,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        graph = new int[N][M];
        List<int[]> tomatoExist =new ArrayList<>();
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
                if(graph[i][j]==1) {
                    tomatoExist.add(new int[]{i,j});
                }
            }
        }
        bfs(tomatoExist);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j]==0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);

    }
    public static void bfs(List<int[]> tomatoes) {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] tomato : tomatoes) {
            queue.add(new int[]{tomato[0], tomato[1], 0});
        }
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                result = poll[2];
                int moveCol = poll[0] + dy[i];
                int moveRow = poll[1] + dx[i];
                if (moveCol >= 0 && moveRow >= 0 && moveCol < N && moveRow < M) {
                    if(graph[moveCol][moveRow]==0) {
                        graph[moveCol][moveRow] = poll[2]+1;
                        queue.add(new int[]{moveCol,moveRow,poll[2]+1});
                    }
                }
            }
        }
    }
}