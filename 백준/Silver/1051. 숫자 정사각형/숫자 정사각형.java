import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = arr[i][j];
                for (int k = Math.min(N-i, M-j) -1; k >= 0; k--) {
                    if (num != arr[i+k][j+k])
                        continue;
                    if (num != arr[i][j+k])
                        continue;
                    if (num != arr[i+k][j])
                        continue;
                    max = Math.max((k+1)*(k+1), max);
                    break;
                }
            }
        }
        System.out.println(max);

    }
}