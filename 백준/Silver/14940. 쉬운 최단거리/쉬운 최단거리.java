import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M;
    static int targetCol, targetRow;
    static int[] dx= {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] visited, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visited = new int[N][M];
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                visited[i][j] = Integer.parseInt(s[j]);
                if(visited[i][j]==2){
                    targetCol = i;
                    targetRow = j;
                }
            }
        }
        bfs(targetCol,targetRow);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]==1 && arr[i][j] ==0)
                    System.out.print("-1 ");
                else System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void bfs(int col, int row) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col,row,0});
        visited[col][row] = 0;
        arr[col][row] = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveCol = poll[0]+dy[i];
                int moveRow = poll[1]+dx[i];
                if(moveCol>=0&&moveRow>=0&&moveCol<N&&moveRow<M&&visited[moveCol][moveRow]!=0) {
                    visited[moveCol][moveRow] = 0;
                    arr[moveCol][moveRow] = poll[2]+1;
                    queue.add(new int[]{moveCol,moveRow,poll[2]+1});
                }
            }
        }
    }
}