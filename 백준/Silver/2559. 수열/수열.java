import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] sum = new int[N-K+1];
        for (int j = 0; j < K; j++) {
            sum[0] += arr[j];
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + arr[i+K-1] - arr[i-1];
        }

        Arrays.sort(sum);
        System.out.println(sum[sum.length-1]);
    }
}