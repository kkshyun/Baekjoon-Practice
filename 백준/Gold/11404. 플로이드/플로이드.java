import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        long[][] arr = new long[N+1][N+1];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(arr[i],Long.MAX_VALUE);
            arr[i][i]=0;
        }
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            if(arr[start][end]!=0&&arr[start][end]<cost)
                continue;
            arr[start][end] = cost;
        }
        // 중간점
        for (int i = 1; i < N+1; i++) {
            // 시작점
            for (int j = 1; j < N+1; j++) {
                // 끝점
                for (int k = 1; k < N+1; k++) {
                    if(arr[j][i]==Long.MAX_VALUE||arr[i][k]==Long.MAX_VALUE)
                        continue;
                    if(arr[j][k]>arr[j][i]+arr[i][k])
                        arr[j][k] = arr[j][i]+arr[i][k];
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(arr[i][j]==Long.MAX_VALUE)
                    System.out.print(0+" ");
                else
                    System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}