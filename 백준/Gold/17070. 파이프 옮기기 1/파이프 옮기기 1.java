import java.io.*;

public class Main {
    static int result = 0;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(1,0,1);
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int instance, int col, int row) {
        if(col==N-1 && row==N-1) {
            result++;
            return;
        }
        int moveCol = col + 1;
        int moveRow = row + 1;
        if(moveCol<N&&moveRow<N &&arr[col][moveRow]!=1&&arr[moveCol][row]!=1 &&arr[moveCol][moveRow]!=1) {
            dfs(3,moveCol,moveRow);
        }
        if(instance == 1) {
            moveCol = col;
            moveRow = row + 1;
            if(moveRow<N && arr[moveCol][moveRow]!=1) {
                dfs(1,moveCol,moveRow);
            }
        } else if(instance == 2) {
            moveCol = col+1;
            moveRow = row;
            if(moveCol<N && arr[moveCol][moveRow]!=1) {
                dfs(2,moveCol,moveRow);
            }
        } else if(instance == 3) {
            moveCol = col;
            moveRow = row + 1;
            if(moveRow<N && arr[moveCol][moveRow]!=1) {
                dfs(1,moveCol,moveRow);
            }
            moveCol = col+1;
            moveRow = row;
            if(moveCol<N && arr[moveCol][moveRow]!=1) {
                dfs(2,moveCol,moveRow);
            }
        }

    }
}