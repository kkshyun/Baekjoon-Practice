import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int l,endCol, endRow;
    static int[][] arr;
    static int[] dy = {1,2,-1,-2,1,2,-1,-2};
    static int[] dx = {2,1,2,1,-2,-1,-2,-1};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            String[] s = br.readLine().split(" ");
            int startCol = Integer.parseInt(s[0]);
            int startRow = Integer.parseInt(s[1]);
            s = br.readLine().split(" ");
            endCol = Integer.parseInt(s[0]);
            endRow = Integer.parseInt(s[1]);

            dfs(startCol,startRow, 0);
        }
        bw.flush();
        bw.close();
    }
    public static void dfs(int col, int row, int currentDepth) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col,row,currentDepth});
        arr[col][row] = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(poll[0]==endCol&&poll[1]==endRow) {
                bw.write(poll[2] + "\n");
                return;
            }
            for (int i = 0; i < 8; i++) {
                int moveCol = poll[0]+dy[i];
                int moveRow = poll[1]+dx[i];
                if(moveCol>=0&&moveRow>=0&&moveCol<l&&moveRow<l&&arr[moveCol][moveRow]!=1) {
                    arr[moveCol][moveRow] = 1;
                    queue.add(new int[]{moveCol, moveRow,poll[2]+1});
                }
            }
        }

    }
}