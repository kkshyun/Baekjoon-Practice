import java.io.*;

public class Main {
    static int N;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int color;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] arrForColorBlindness = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if(s.charAt(j)=='R'){
                    arr[i][j] = 1;
                    arrForColorBlindness[i][j] = 1;
                }
                else if(s.charAt(j)=='G'){
                    arr[i][j] = 2;
                    arrForColorBlindness[i][j] = 1;
                }
                else{
                    arr[i][j] = 3;
                    arrForColorBlindness[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]!=0){
                    count++;
                    color=arr[i][j];
                    dfs(i,j,arr);
                }
            }
        }
        bw.write(count+" ");
        count=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arrForColorBlindness[i][j]!=0){
                    count++;
                    color=arrForColorBlindness[i][j];
                    dfs(i,j,arrForColorBlindness);
                }
            }
        }
        bw.write(count+" ");
        bw.flush();
        bw.close();
    }
    public static void dfs(int x, int y, int[][] colors) {
        colors[x][y]=0;
        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];
            if(moveX>=0&&moveY>=0&&moveX<N&&moveY<N) {
                if(color==colors[moveX][moveY])
                    dfs(moveX,moveY,colors);
            }
        }
    }
}