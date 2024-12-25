import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int height;
    static int[][] temp;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int count, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int max = 0;
        // 입력 받기
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if(arr[i][j]>max)
                    max = arr[i][j];
            }

        }

        result = 0;

        for (int i = 1; i <= max; i++) {
            temp = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[j][k] = arr[j][k];
                }
            }
            count = 0;
            height = i;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(temp[j][k]>=height){
                        count++;
                        dfs(j,k);
                    }
                }
            }
            if(count>result)
                result = count;
        }
        System.out.println(result);
    }

    public static void dfs(int col, int row) {
        temp[col][row] = 0;
        for (int i = 0; i < 4; i++) {
            int moveCol = col + dy[i];
            int moveRow = row + dx[i];
            if(moveCol>=0&&moveRow>=0&&moveCol<N&&moveRow<N&&temp[moveCol][moveRow]>=height) {
                dfs(moveCol,moveRow);
            }
        }
    }
}