import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int n;
    static int[][] graph, dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i],100000000);
        }
        dist[0][0] = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }
        bfs_0_1();
        System.out.println(dist[n-1][n-1]);
    }
    public static void bfs_0_1() {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0});
        while(!deque.isEmpty()) {
            int[] remove = deque.removeFirst();
            int col = remove[0];
            int row = remove[1];

            for (int i = 0; i < 4; i++) {
                int moveCol = col + dy[i];
                int moveRow = row + dx[i];
                if(moveCol<n&&moveRow<n&&moveCol>=0&&moveRow>=0) {
                    if(graph[moveCol][moveRow]==0) {
                        if (dist[moveCol][moveRow] > dist[col][row] + 1) {
                            dist[moveCol][moveRow] = dist[col][row] + 1;
                            deque.addLast(new int[]{moveCol, moveRow});
                        }
                    }else if(graph[moveCol][moveRow]==1) {
                        if (dist[moveCol][moveRow] > dist[col][row]) {
                            dist[moveCol][moveRow] = dist[col][row];
                            deque.addLast(new int[]{moveCol, moveRow});
                        }
                    }
                }
            }
        }
    }
}