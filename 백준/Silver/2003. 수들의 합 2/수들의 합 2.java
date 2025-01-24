import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        int sum = 0;
        while (true) {
            if (sum >= M) {
                sum -= arr[startIndex++];
            } else if (endIndex == N) {
                break;
            } else {
                sum += arr[endIndex++];
            }

            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);

    }
}