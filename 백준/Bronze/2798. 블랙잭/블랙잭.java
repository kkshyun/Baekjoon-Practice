import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[] arr, result;
    static int maxSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N];
        result = new int[3];
        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        combination(0,0);
        System.out.println(maxSum);
    }
    public static void combination(int start, int r) {
        if(r == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += result[i];
            }
            if(sum <= M)
                maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = start; i < N; i++) {
            result[r] = arr[i];
            combination(i+1, r+1);
        }
    }
}