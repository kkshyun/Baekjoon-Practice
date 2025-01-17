import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] dz = {-1,1};
    static int[][][] graph;
    static int M,N,H,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        graph = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                s = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    graph[i][j][k] = Integer.parseInt(s[k]);
                }
            }
        }

        bfs();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(graph[i][j][k]==0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(graph[i][j][k]==1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            result = poll[3];
            for (int i = 0; i < 4; i++) {
                int moveCol = dy[i] + poll[1];
                int moveRow = dx[i] + poll[2];
                if(moveCol>=0&&moveCol<N&&moveRow>=0&&moveRow<M&&graph[poll[0]][moveCol][moveRow]==0) {
                    graph[poll[0]][moveCol][moveRow]=1;
                    queue.add(new int[]{poll[0],moveCol,moveRow,poll[3]+1});
                }
            }
            for (int i = 0; i < 2; i++) {
                int moveZ = dz[i]+poll[0];
                if(moveZ>=0&&moveZ<H&&graph[moveZ][poll[1]][poll[2]]==0) {
                    graph[moveZ][poll[1]][poll[2]]=1;
                    queue.add(new int[]{moveZ,poll[1],poll[2],poll[3]+1});
                }
            }
        }

    }
}