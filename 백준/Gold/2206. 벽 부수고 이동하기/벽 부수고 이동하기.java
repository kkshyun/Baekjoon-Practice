import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] graph;
    static int[][][] visited;
    static int N, M;
    static List<Integer> results;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited = new int[N][M][2];
        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,1});
        visited[0][0][0] = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int col = poll[0];
            int row = poll[1];
            int breakCount = poll[2];
            int depth = poll[3];

            if(col==N-1&& row==M-1)
                return depth;

            for (int i = 0; i < 4; i++) {
                int moveCol = col + dy[i];
                int moveRow = row + dx[i];
                if(moveCol<N&&moveRow<M&&moveCol>=0&&moveRow>=0) {

                    if(graph[moveCol][moveRow]==1 && breakCount<1) {
                        if(visited[moveCol][moveRow][breakCount+1]==1)
                            continue;
                        queue.add(new int[]{moveCol, moveRow, breakCount + 1, depth + 1});
                        visited[moveCol][moveRow][breakCount+1]=1;
                    }
                    else if(graph[moveCol][moveRow]==0) {
                        if(visited[moveCol][moveRow][breakCount]==1)
                            continue;
                        queue.add(new int[]{moveCol, moveRow, breakCount, depth + 1});
                        visited[moveCol][moveRow][breakCount]=1;
                    }
                }
            }
        }
        return -1;
    }
}