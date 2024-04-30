import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] result = new long[num];
        for(int i = 0 ; i<num;i++) {
            String[] arr = br.readLine().split(" ");
            int M = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            System.out.println(combi(N,M));
        }

    }
    public static int combi(int n, int m) {
        if(n==m || m==0) return 1;
        if(dp[n][m]!=0) return dp[n][m];
        return dp[n][m] = combi(n-1, m-1) + combi(n-1, m);
    }
}
