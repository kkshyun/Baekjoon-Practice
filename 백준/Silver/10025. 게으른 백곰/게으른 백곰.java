import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1])*2+1;
        int[] arr = new int[1000001];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            arr[Integer.parseInt(s[1])] = Integer.parseInt(s[0]);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            if(i >= arr.length)
                break;
            sum += arr[i];
        }
        int max = sum;
        for (int i = 0; i < arr.length-K; i++) {
            sum = sum - arr[i] + arr[i+K];
            if(sum>max)
                max = sum;
        }
        System.out.println(max);
    }
}