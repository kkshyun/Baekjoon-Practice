import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    static int[][] graph;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);
        graph = new int[M][N];
        for (int i = 0; i < K; i++) {
            s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    graph[j][k] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(graph[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        bw.write(list.size()+"\n");
        Collections.sort(list);
        for(Integer i : list) {
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int col, int row) {
        graph[col][row] = 1;
        count += 1;
        for (int i = 0; i < 4; i++) {
            int moveCol = col + dy[i];
            int moveRow = row + dx[i];
            if(moveCol<M && moveRow<N && moveCol>=0 && moveRow>=0 && graph[moveCol][moveRow] == 0) {
                dfs(moveCol,moveRow);
            }
        }
    }
}