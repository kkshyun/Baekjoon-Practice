import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[][] arr = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i],10000000);
            }
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < s.length; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }
            // dijkstra
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2],o2[2]));
            queue.add(new int[]{0,0,arr[0][0]});
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int col = poll[0];
                int row = poll[1];
                if(col==N-1&&row==N-1) {
                    bw.write("Problem "+count+": "+poll[2]+"\n");
                    count++;
                    break;
                }
                if(visited[col][row])
                    continue;
                visited[col][row] = true;
                dist[col][row] = poll[2];
                for (int i = 0; i < 4; i++) {
                    int moveCol = col + dy[i];
                    int moveRow = row + dx[i];
                    if(moveCol<N&&moveRow<N&&moveCol>=0&&moveRow>=0) {
                        if(dist[moveCol][moveRow]>dist[col][row]+arr[moveCol][moveRow]) {
                            dist[moveCol][moveRow] = dist[col][row]+arr[moveCol][moveRow];
                            queue.add(new int[]{moveCol,moveRow,dist[moveCol][moveRow]});
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
