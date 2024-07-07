import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][n+1];
        long[] sNum = new long[n*n+1];
        long[] total = new long[m];
        for(int i = 1; i < n+1 ; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<n+1 ; j++) {
                arr[i][j] = Integer.parseInt(s.nextToken());
                sNum[(i-1)*n+j] = sNum[(i-1)*n+j-1] + arr[i][j];
            }
        }

        for(int i = 0; i < m ; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(s.nextToken());
            int y1 = Integer.parseInt(s.nextToken());
            int x2 = Integer.parseInt(s.nextToken());
            int y2 = Integer.parseInt(s.nextToken());
            int repeat = x2 - x1 + 1;
            for(int j = 0 ;j < repeat; j++) {
                total[i] += sNum[(x2-1)*n+y2] - sNum[(x2-1)*n+y1-1];
                x2--;
            }
        }

        for(int i = 0 ;i < m ;i++) {
            System.out.println(total[i]);
        }
        br.close();
    }
}
