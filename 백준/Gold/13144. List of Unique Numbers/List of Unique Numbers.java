import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        long sum = 0;
        boolean[] visited = new boolean[100001];

        int l = 0;
        for (int i = 0; i < N; i++) {
            // 이미 윈도우에 있음
            while (visited[arr[i]]) {
                visited[arr[l]] = false;
                l++;
            }
            visited[arr[i]] = true;
            sum += i - l + 1;
        }
        System.out.println(sum);
    }
}