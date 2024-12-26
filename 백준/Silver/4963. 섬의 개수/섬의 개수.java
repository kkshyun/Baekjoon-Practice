import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int w, h;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] diagonalDx = {-1,1,-1,1};
    static int[] diagonalDy = {1,1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] s = br.readLine().split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            if(w==0&&h==0)
                break;
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                s = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    arr[i][j]=Integer.parseInt(s[j]);
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j]>0){
                        count++;
                        bfs(i,j);
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void bfs(int col, int row) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{col,row});
        arr[col][row]=0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveCol = poll[0] + dy[i];
                int moveRow = poll[1] + dx[i];
                if(moveCol>=0&&moveRow>=0&&moveCol<h&&moveRow<w&&arr[moveCol][moveRow]!=0){
                    arr[moveCol][moveRow]=0;
                    queue.add(new int[]{moveCol,moveRow});
                }

            }
            for (int i = 0; i < 4; i++) {
                int moveCol = poll[0] + diagonalDy[i];
                int moveRow = poll[1] + diagonalDx[i];
                if(moveCol>=0&&moveRow>=0&&moveCol<h&&moveRow<w&&arr[moveCol][moveRow]!=0){
                    arr[moveCol][moveRow]=0;
                    queue.add(new int[]{moveCol,moveRow});
                }
            }
        }

    }
}