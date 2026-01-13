import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static StringBuilder sb;
    static int[] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        result = new int[M];
        combination(0,0);
        System.out.println(sb.toString());
    }
    public static void combination(int start, int r) {
        if(r == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            result[r] = arr[i];
            combination(i, r+1);
        }
    }
}