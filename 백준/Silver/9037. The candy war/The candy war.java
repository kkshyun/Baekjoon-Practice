import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[j] = temp % 2 == 0 ? temp : temp+1;
            }
            int count = 0;
            while(true) {
                boolean check = true;
                for (int j = 0; j < N-1; j++) {
                    if(arr[j] != arr[j+1]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    sb.append(count).append("\n");
                    break;
                }
                int[] next = new int[N];

                for (int j = 0; j < N; j++) {
                    int give = arr[j] / 2;
                    next[j] += arr[j] / 2;
                    next[(j + 1) % N] += give;
                }

                for (int j = 0; j < N; j++) {
                    if (next[j] % 2 == 1) next[j]++;
                    arr[j] = next[j];
                }
                count++;
            }
        }
        System.out.println(sb);
    }
}