import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long sum = 1;
        for (int i = N; i >= N-K+1 ; i--) {
            sum *= i;
        }
        for (int i = 1; i <= K; i++) {
            sum /= i;
        }
        System.out.println(sum);
    }
}