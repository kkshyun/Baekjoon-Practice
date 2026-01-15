import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
                    result[j] += 1;
                } else if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    result[i] += 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(result[i]+1).append(" ");
        }
        System.out.println(sb);
    }
}