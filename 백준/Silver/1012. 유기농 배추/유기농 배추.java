import java.io.*;

public class Main {
    static int result;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            // 가로
            M = Integer.parseInt(s[0]);
            // 세로
            N = Integer.parseInt(s[1]);
            int K = Integer.parseInt(s[2]);
            arr = new int[N][M];
            for (int j = 0; j < K; j++) {
                s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                arr[y][x] = 1;
            }
            result = 0;

            // j : 세로, k : 가로
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[j][k]==1) {
                        result+=1;
                        DFS(j,k);
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
    public static void DFS(int y, int x) throws IOException {
        arr[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int moveX = x+dx[i];
            int moveY = y+dy[i];
            if(moveX>=0&&moveY>=0&&moveX<M&&moveY<N) {
                if(arr[moveY][moveX]!=0)
                    DFS(moveY,moveX);
            }
        }

    }
}
